package ir.bs.tenant_and_landlord.config;

import ir.bs.tenant_and_landlord.domain.User;
import ir.bs.tenant_and_landlord.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by : Pourya Bahrami
 * Date : 10/29/21
 * Time : 10:08 PM
 */

@Configuration
public class MyLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UserService service;

    public MyLoginSuccessHandler(UserService service) {
        this.service = service;
    }

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);
        if(response.isCommitted()){
            return;
        }
        RedirectStrategy strategy = new DefaultRedirectStrategy();
        strategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        String url = "/login?error=ture";
        User user = service.findByUserName(authentication.getName());
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority authority: authorities){
            roles.add(authority.getAuthority());
        }
        if(roles.contains("ROLE_ADMIN")){
            url = "/admin";
        }else if (roles.contains("ROLE_MASTER")){
            url = "/master";
        }else if (roles.contains("ROLE_STUDENT")){
            url = "/student";
        }else {
            url = "/user/not-registered";
        }
        return url;
    }
}
