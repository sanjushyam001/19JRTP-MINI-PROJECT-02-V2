package in.ashokit.controller.rest;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.UserForm;
import in.ashokit.service.UserMgmtService;




@RestController
@RequestMapping("user-management")
@CrossOrigin("*")
public class UserRegistrationRestController {

	@Autowired
	private UserMgmtService service;
	
	
	
	//#1.get all countries
	
	@GetMapping("/countries")
	public ResponseEntity<?> getAllCountries(){
		
		ResponseEntity<?> resp=null;
		Map<Integer,String> countriesMap=service.loadCountries();
		if(countriesMap.isEmpty()||countriesMap==null) {
			resp=new ResponseEntity<String>("Data is not found",HttpStatus.NOT_FOUND);
		}else {
			resp=new ResponseEntity<Map<Integer, String>>(countriesMap,HttpStatus.OK);
		}
		return resp;
	}
	
	
	//#2.get all states by country id
	
	@GetMapping("/states/{countryId}")
	public ResponseEntity<?> getAllStatesByCountryId(@PathVariable Integer countryId){

		
		ResponseEntity<?> resp=null;
		Map<Integer, String> states = service.loadStates(countryId);
		if(states.isEmpty()||states==null) {
			resp=new ResponseEntity<String>("Data not found..",HttpStatus.NOT_FOUND);
		}else {
			resp=new ResponseEntity<Map<Integer, String>>(states,HttpStatus.OK);
		}
		return resp;
	}
	
	
	//#4. get all cities by state id
	@GetMapping("/cities/{stateId}")
	public ResponseEntity<?> getAllCitiesByStateId(@PathVariable Integer stateId){
		
		ResponseEntity<?> resp=null;
		
		Map<Integer, String> cities = service.loadCities(stateId);
		if(cities.isEmpty()||cities==null) {
			resp=new ResponseEntity<String>("No Data Found",HttpStatus.NOT_FOUND);
		}else {
			resp=new ResponseEntity<Map<Integer, String>>(cities,HttpStatus.OK);
		}
		return resp;
	}
	
	
	//# checking email is already registered ?
	
	@GetMapping("/email/{email}")
	public ResponseEntity<?> isDuplicateEmaild(@PathVariable String email){
		
		
		ResponseEntity<?> resp=null;
		String status = service.emailCheck(email);
		
		resp=new ResponseEntity<String>(status,HttpStatus.OK);
		return resp;
		
	}
	
	//# save User
	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@RequestBody UserForm userForm){
	
		
		
		ResponseEntity<?> resp=null;
		String status = service.saveUser(userForm);
		
		return new ResponseEntity<String>(status,HttpStatus.OK);
		
	}
	
}
