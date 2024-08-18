package auth_main.config;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import auth_main.dtos.LoginRequest;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    
//	custom login end point added.
    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.setFilterProcessesUrl("/api/auth/login");
    }
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            // Deserialize the login request
            LoginRequest loginRequest = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
            // Determine whether to use username or email for authentication
            String identifier = loginRequest.getUserName() != null ? loginRequest.getUserName() : loginRequest.getEmail();

            // Create the authentication token
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(identifier, loginRequest.getPassword());

            // Authenticate using the token
            return authenticationManager.authenticate(authenticationToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        SecurityContextHolder.getContext().setAuthentication(authResult);

        System.out.println("Authenticated");
        // Custom logic for successful authentication
        // For example, generating a JWT token
        String token = "your-generated-jwt-token"; // This should be replaced with actual JWT generation logic

        response.setHeader("Authorization", "Bearer " + token);
        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper().writeValueAsString("Login successful"));
    }
    
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
    		AuthenticationException failed) throws IOException, ServletException {
    	super.unsuccessfulAuthentication(request, response, failed);
    }
    

}
