package in.ashokit.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.UnlockAccForm;
import in.ashokit.service.UserMgmtService;

@RestController
@RequestMapping("user-management")
@CrossOrigin("*")
public class UnlockUserAccntRestController {

	@Autowired
	private UserMgmtService service;
	
	@PostMapping("/unlock-user")
	public ResponseEntity<?> unlockUserAccnt(@RequestBody UnlockAccForm unlockAccForm){
		ResponseEntity<?> resp=null;
		String status = service.unlockAcc(unlockAccForm);
		resp=new ResponseEntity<String>(status,HttpStatus.OK);
		return resp;
	}
}
