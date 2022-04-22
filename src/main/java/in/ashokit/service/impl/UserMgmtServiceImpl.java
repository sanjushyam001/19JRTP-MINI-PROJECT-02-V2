package in.ashokit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.City;
import in.ashokit.entity.Country;
import in.ashokit.bindings.LoginForm;
import in.ashokit.entity.State;
import in.ashokit.bindings.UnlockAccForm;
import in.ashokit.entity.User;
import in.ashokit.bindings.UserForm;
import in.ashokit.repository.CityRepository;
import in.ashokit.repository.CountryRepository;
import in.ashokit.repository.StateRepository;
import in.ashokit.repository.UserRepository;
import in.ashokit.service.EmailService;
import in.ashokit.service.UserMgmtService;
import in.ashokit.utils.email.EmailUtils;
import in.ashokit.utils.password.PasswordUtils;

@Service
public class UserMgmtServiceImpl implements UserMgmtService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private PasswordUtils passwordUtils;
	
	@Override
	public String loginCheck(LoginForm loginForm) {
		
		String email=loginForm.getEmail();
		String password=loginForm.getPassword();
		User user= userRepo.findByEmailAndPassword(email, password);
		if(user==null) {
			return "invalid";
		}
		if(user.getStatus().equalsIgnoreCase("LOCKED")) {
			return "locked";
		}
		return "valid";
	}

	@Override
	public String emailCheck(String email) {
		
		return userRepo.findByEmail(email)==null?"UNIQUE":"DUPLICATE";
	}

	@Override
	public Map<Integer, String> loadCountries() {
		List<Country> countries = countryRepo.findAll();
		Map<Integer, String> countryMap=new HashMap<>();
		countries.forEach(country->{
			countryMap.put(country.getId(), country.getName());
		});
		return countryMap;
	}

	@Override
	public Map<Integer, String> loadStates(Integer countryId) {
		List<State> states = stateRepo.findByCountryId(countryId);
		Map<Integer, String> stateMap=new HashMap<>();
		states.forEach(state->{
			stateMap.put(state.getId(), state.getName());
		});
		return stateMap;
	}

	@Override
	public Map<Integer, String> loadCities(Integer stateId) {
		
		List<City> cities = cityRepo.findByStateId(stateId);
		Map<Integer, String> cityMap=new HashMap<>();
		cities.forEach(city->{
			cityMap.put(city.getId(), city.getName());
		});
		return cityMap;
	}
	@Override
	public String saveUser(UserForm userForm) {
		String generatedPaswd=PasswordUtils.generatePassword();
		
		User user=new User();
		user.setStatus("LOCKED");
		user.setPassword(generatedPaswd);
		BeanUtils.copyProperties(userForm, user);
		userRepo.save(user);
		
		// send Email with temp paswd to unclick accnt
		String email=userForm.getEmail();
		String emailBody=readEmailBody(userForm, generatedPaswd);
		emailService.sendEmail(email, emailUtils.getSubject(), emailBody);
			
		return "User registered successfully";
	}
	private String readEmailBody(UserForm userForm,String generatedPaswd) {
	
		
		String emailBody=emailUtils.readUnlockAccEmailBody(userForm,generatedPaswd);
		return emailBody;
	}

	@Override
	public String forgotPwd(String email) {
		User user=userRepo.findByEmail(email);
		if(user==null) {
			return "{\"status\":\"invalid\"}";
		}
		// send password to email
		String body="Your password is : "+user.getPassword();
		emailService.sendEmail(user.getEmail(), "Password Recovered", body);
		String value ="{\"status\":\"valid\"}";
		return value;
		
	}

	@Override
	public String unlockAcc(UnlockAccForm unlockAccForm) {
		User user= userRepo.findByEmailAndPassword(unlockAccForm.getEmail(), unlockAccForm.getTempPaswd());
		
		if(user==null) {
			return "invalid";
		}
		user.setPassword(unlockAccForm.getNewPaswd());
		user.setStatus("UNLOCKED");
		userRepo.save(user);
		return "valid";
		
	}
	
	

}
