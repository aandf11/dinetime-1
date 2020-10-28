package se452.group5.dinetime;

import java.security.Principal;
import java.sql.Date;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import lombok.Data;


@Data
@Entity
public class TableAvailability {
    
    @Id
    @GeneratedValue
    private long id;

    private String table_id;


    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "Restaurant", nullable = false)
    private Restaurant restaurant;

    private String location_id;

    private boolean available;

    private int seats;

    private String time;

    private Date date;
}
