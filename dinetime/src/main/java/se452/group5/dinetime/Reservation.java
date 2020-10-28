package se452.group5.dinetime;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

import se452.group5.dinetime.model.*;
import lombok.Data;
import java.sql.Date;

@Data
@Entity
public class Reservation {
        
  
    @Id
    @GeneratedValue
    private long id;

    private String reservation_id;

    
    private String location_id; 

    @ManyToOne(targetEntity = CustomerAccount.class, cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private CustomerAccount user_id;

    
    private String table_id;

    private String time;

    private Date date;

}
