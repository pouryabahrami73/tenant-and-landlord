package ir.bs.tenant_and_landlord.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by : Pourya Bahrami
 * Date : 10/29/21
 * Time : 9:57 PM
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationProvider authenticationProvider;
    private final MyLoginSuccessHandler successHandler;

    public SecurityConfig(CustomAuthenticationProvider authenticationProvider, MyLoginSuccessHandler successHandler) {
        this.authenticationProvider = authenticationProvider;
        this.successHandler = successHandler;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
                .authorizeRequests()
                .antMatchers("../static/css/**").permitAll()
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .mvcMatchers("/sign-up-form").permitAll()
                .mvcMatchers("/user/not-registered").hasAnyRole("MASTER", "STUDENT")
                .mvcMatchers("/master/**").hasAnyRole("MASTER", "ADMIN")
                .mvcMatchers("/student/**").hasAnyRole("STUDENT", "ADMIN")
                .mvcMatchers("/sign-in").permitAll()
                .and().formLogin()
                .loginPage("/login").permitAll().successHandler(successHandler)
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
    }
}
