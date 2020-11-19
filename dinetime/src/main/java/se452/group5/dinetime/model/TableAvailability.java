package se452.group5.dinetime.model;

import java.security.Principal;
import java.sql.Date;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.FetchType;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Transient;

import lombok.NoArgsConstructor;



import javax.persistence.OneToOne;

import javax.persistence.OneToOne;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name="table_availability")
public class TableAvailability {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    
    @ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
    @JoinColumn(name = "restaurants")
    private Restaurant restaurant;
    

    // @OneToOne(cascade = CascadeType.ALL,mappedBy = "table")
    // private Reservation reservation;


 
    @JsonIgnore
    @OneToOne(
        cascade = CascadeType.ALL,
        fetch=FetchType.LAZY,
        orphanRemoval = true
         )
    @JoinColumn(name = "reservations")
    @ToString.Exclude
    private Reservation reservation;

    // @OneToOne(cascade = CascadeType.ALL,mappedBy = "tableAvailability")
    // private Reservation reservation;
    


    private boolean available;

    private int seats;

    private String time;

   
    // @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date date;
}
