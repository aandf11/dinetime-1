package se452.group5.dinetime;

import java.util.List;
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


@Data
@Entity
@Table(name="customer_accounts")
public class CustomerAccount {


    @Id
	@GeneratedValue
	private long id;
    
    @Column(name = "user_id")
	private String userId;

	@Column(name = "nm")
	private String name;

	@Email(message = "not valid email address format")
	private String email;


	@OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY, mappedBy = "customerAccount")
    @ToString.Exclude
	private List<Rate> rateList=new ArrayList<>();




    
}
