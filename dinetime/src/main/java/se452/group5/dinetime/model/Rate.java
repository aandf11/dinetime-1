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


@Data
@Entity
@Table(name="rates")
public class Rate {
    
    @Column
    @Id
    @GeneratedValue
    private long id;


    @ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private CustomerAccount user_id;


    private String star;


    @ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
    @JoinColumn(name = "restaurants")
    private Restaurant restaurant;
    
    



    
}
