package auth_main.services.implementation;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import auth_main.models.User;
import auth_main.repos.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;
	
	
	@Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        // Load user by either username or email
        User user = userRepository.findByUserNameOrEmail(identifier, identifier)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username or email: " + identifier));
        
        return new CustomUserDetails(user);
    }
}
