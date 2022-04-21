package in.ashokit.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.service.UserMgmtService;

@RestController
@RequestMapping("user-management")
@CrossOrigin(origins = "http://localhost:4200")
public class ForgotUserPaswdRestController {

	@Autowired
	private UserMgmtService service;
	
	@PostMapping("/forgot-passwd/{email}")
	public ResponseEntity<?> ForgotUserPaswd(@PathVariable String email) {
	
		ResponseEntity<?> resp=null;
		String status = service.forgotPwd(email);
		resp=new ResponseEntity<String>(status,HttpStatus.OK);
		return resp;
		
	}
}
