package ir.bs.tenant_and_landlord.config;

import ir.bs.tenant_and_landlord.service.CustomUserDetailsService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by : Pourya Bahrami
 * Date : 10/29/21
 * Time : 9:58 PM
 */

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final CustomUserDetailsService customUserDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Lazy
    public AuthenticationProviderImpl(CustomUserDetailsService customUserDetailsService, PasswordEncoder passwordEncoder) {
        this.customUserDetailsService = customUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            return new UsernamePasswordAuthenticationToken(
                    authentication.getPrincipal(),
                    password,
                    userDetails.getAuthorities());
        } else {
            throw new BadCredentialsException("رمز عبور اشتباه است!");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
