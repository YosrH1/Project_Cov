package BackendCovoiturage.BackendCovoiturage;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    // This is a placeholder for your authentication logic (e.g., database lookup)
    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Example: Check the username and password (replace with your logic)
        if ("user".equals(username) && "password".equals(password)) {
            UserDetails userDetails = new User(username, password, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
            return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        }
        return null; // If authentication fails, return null
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
