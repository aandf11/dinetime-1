package se452.group5.dinetime.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

import lombok.Data;
import java.sql.Date;

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

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


@Data
@Entity
@Table(name="reservations")
public class Reservation {
        
  
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    // private String reservation_id;

    //it might be restaurant id
    // private String location_id; 


    //targetEntity = CustomerAccount.class
    @ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private CustomerAccount user_id;



    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "table_availability")
    // private TableAvailability table;


    @OneToOne(cascade = CascadeType.MERGE,mappedBy = "reservation", orphanRemoval = false)
    private TableAvailability table;
    
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "table_availability")
    // private TableAvailability tableAvailability;



    
    private String table_id;

    //this is for test
    private String customer_id;
    
    private String restaurant;
    

    private String time;

    private Date date;

    private int seats;

	// public void setRestaurant(String name) {
	// }



}
