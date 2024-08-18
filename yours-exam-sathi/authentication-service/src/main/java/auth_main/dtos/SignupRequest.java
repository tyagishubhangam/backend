package auth_main.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequest {

	@NotBlank(message = "UserName is required")
	@Size(min=5,message = "UserName must be at least 5 characters")
	private String userName;
	
	@NotBlank(message = "Password is required")
	@Size(min=6,message ="Password must be at least 6 characters")
	private String password;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	private String email;
}
