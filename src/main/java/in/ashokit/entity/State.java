package in.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Data
@NoArgsConstructor
@Entity
@Table(name = "STATE_MASTER")
public class State {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Integer countryId;
	
	
	public State(String name, Integer countryId) {
		super();
		this.name = name;
		this.countryId = countryId;
	}
	
	
}
