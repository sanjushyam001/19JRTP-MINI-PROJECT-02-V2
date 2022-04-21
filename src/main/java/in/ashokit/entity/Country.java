package in.ashokit.entity;

import java.time.LocalDate;

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
@Table(name = "COUNTRY_MASTER")
public class Country {

	@Id
	@GeneratedValue
	private Integer id;
	private String code;
	private String name;
	
	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	
}
