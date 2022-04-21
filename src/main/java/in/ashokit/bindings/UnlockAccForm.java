package in.ashokit.bindings;

import lombok.Data;

@Data
public class UnlockAccForm {

	private String email;
	private String tempPaswd;
	private String newPaswd;
	private String confirmPaswd;
	
}
