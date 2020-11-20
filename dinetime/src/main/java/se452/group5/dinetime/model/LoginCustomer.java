package se452.group5.dinetime.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;



@Data
@Entity
@Table(name="login_customer")
public class LoginCustomer {
    @Column
    @Id
    @GeneratedValue
    private Integer id;
	
	@Column(name = "user_id")
	private String userId;

	
	private String password;
}
