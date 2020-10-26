package se452.group5.dinetime.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.FetchType;

import javax.validation.constraints.Email;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Transient;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="customer_accounts")
public class CustomerAccount{


	// @Id
	// @GeneratedValue(generator = "uuid")
	// @GenericGenerator(name = "uuid", strategy = "uuid2")
	// private UUID id;

	@Column
    @Id
    @GeneratedValue
    private Integer id;
	
	@Column(name = "user_id")
	private String userId;

	@Column(name = "nm")
	private String name;

	@Email(message = "not valid email address format")
	private String email;


	// @OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY, mappedBy = "customerAccount")
    // @ToString.Exclude
	// private List<Rate> rateList=new ArrayList<>();


	// @OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY, mappedBy = "user_id")
	// @ToString.Exclude
	// private List<Reservation> reservationList=new ArrayList<>();
	
}
