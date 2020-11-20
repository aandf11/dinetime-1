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

import javax.persistence.OneToOne;

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
    
 
    @JsonIgnore
    @OneToOne(
        cascade = CascadeType.ALL,
        fetch=FetchType.LAZY,
        orphanRemoval = true
         )
    @JoinColumn(name = "reservations")
    @ToString.Exclude
    private Reservation reservation;



    private boolean available;

    private int seats;

    private String time;

    private Date date;
}
