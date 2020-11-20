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




@Data
@Entity
@Table(name="reservations")
public class Reservation {
        
  
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;





 
    @ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private CustomerAccount user_id;



    @OneToOne(cascade = CascadeType.MERGE,mappedBy = "reservation", orphanRemoval = false)
    private TableAvailability table;
    


    
    private String table_id;


    private String customer_id;
    
    private String restaurant;
    

    private String time;

    private Date date;

    private int seats;




}
