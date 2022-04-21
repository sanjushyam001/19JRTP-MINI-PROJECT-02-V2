package in.ashokit.service;

import java.util.Map;

import in.ashokit.bindings.LoginForm;
import in.ashokit.bindings.UnlockAccForm;
import in.ashokit.bindings.UserForm;

public interface UserMgmtService {

	public String loginCheck(LoginForm loginForm);
	
	public String emailCheck(String email);
	
	public Map<Integer, String> loadCountries();
	
	public Map<Integer, String> loadStates(Integer countryId);
	
	public Map<Integer, String> loadCities(Integer stateId);
	
	public String saveUser(UserForm userForm);
	
	public String forgotPwd(String email);
	
	public String unlockAcc(UnlockAccForm unlockAccForm);
	
	
	
}
