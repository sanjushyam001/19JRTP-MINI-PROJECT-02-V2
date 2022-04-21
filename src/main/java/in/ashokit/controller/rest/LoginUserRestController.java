package in.ashokit.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.LoginForm;
import in.ashokit.service.UserMgmtService;

@RestController
@RequestMapping("user-management")
@CrossOrigin("*")
public class LoginUserRestController {

	@Autowired
	private UserMgmtService service;
	
	@PostMapping("/login-user")
	public ResponseEntity<?> loginUser(@RequestBody LoginForm loginForm){
		ResponseEntity<?> resp=null;
		
		String status = service.loginCheck(loginForm);
		resp=new ResponseEntity<String>(status,HttpStatus.OK);
		return resp;
		
	}
}
