package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Data
@NoArgsConstructor
@Entity
@Table(name = "USER_DTLS")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String phone;
	private LocalDate dob;
	private String gender;
	
	@Column(name = "create_date",updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name = "update_date",insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
	private String status;
	private Integer countryId;
	private Integer stateId;
	private Integer cityId;
	
}
