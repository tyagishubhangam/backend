package auth_main.services;

import auth_main.dtos.LoginRequest;
import auth_main.dtos.SignupRequest;

public abstract class UserServices {
	public abstract void registerNewUser(SignupRequest signUpRequest);

	public abstract void loginUser(LoginRequest loginRequest);
}
