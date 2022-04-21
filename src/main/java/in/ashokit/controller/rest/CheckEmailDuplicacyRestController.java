package in.ashokit.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.service.UserMgmtService;

@RestController
@RequestMapping("user-management")
@CrossOrigin("*")
public class CheckEmailDuplicacyRestController {

	@Autowired
	private UserMgmtService service;
	
	@PostMapping("/email/{emailId}")
	public ResponseEntity<?> isEmaiDuplicate(@PathVariable String emailId) {
	
		ResponseEntity<?> resp=null;
		String status = service.emailCheck(emailId);
		status="{\"status\":\""+status+"\"}";
		resp=new ResponseEntity<String>(status,HttpStatus.OK);
		return resp;
	}
}
