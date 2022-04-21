package in.ashokit.utils.email;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import in.ashokit.bindings.UserForm;
import in.ashokit.utils.password.PasswordUtils;
import lombok.Data;

@Component
@Data
public class EmailUtils {

	private String subject="Unlock User";
	private String body="";
	public String readUnlockAccEmailBody(UserForm userForm,String generatedPaswd) {
		String body="";
		StringBuffer buffer =new StringBuffer();
		//Path filePath=Paths.get("UNLOCK-ACCT-EMAIL-BODY-TEMPLATE.txt");
		Path fpath = Paths.get("UNLOCK-ACCT-EMAIL-BODY-TEMPLATE.txt");
		System.out.println("File Path: "+fpath.toAbsolutePath());
		try(Stream<String> stream=Files.lines(fpath)) {
			
			stream.forEach(line->{
				buffer.append(line);
			});
			
			body=buffer.toString();
			body=body.replace("{FNAME}",userForm.getFname());
			body=body.replace("{LNAME}",userForm.getLname());
			body=body.replace("{TEMP-PWSD}",generatedPaswd);
			body=body.replace("{EMAIL}",userForm.getEmail());
			System.out.println("BODY:: "+body);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return body;
	}
}
