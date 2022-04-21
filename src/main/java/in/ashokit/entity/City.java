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
@Table(name = "CITY_MASTER")
public class City {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Integer stateId;
	
	public City(String name, Integer stateId) {
		super();
		this.name = name;
		this.stateId = stateId;
	}
	
	
}
