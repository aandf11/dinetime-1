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

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="business_accounts")
public class BusinessAccount {
    @Column
    @Id
    @GeneratedValue
    private Integer id;
	
	@Column(name = "user_id")
	private String userId;

	@Column(name = "business_nm")
	private String name;

	@Email(message = "not valid email address format")
	private String email;

	private String password;


	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY, mappedBy = "user_id",orphanRemoval = true)
	@ToString.Exclude
	private List<Restaurant> restaurantList=new ArrayList<>();



    
}
