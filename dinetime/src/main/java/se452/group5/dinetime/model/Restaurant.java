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

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Transient;

import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;




@Data
@NoArgsConstructor
@Entity
@Table(name="restaurants")
public class Restaurant {
    
    @Column
    @Id
    @GeneratedValue
    private Integer id;


    @ManyToOne(targetEntity = BusinessAccount.class, cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private BusinessAccount user_id;


  
    @Column(name = "restaurant_nm")
    private String name;

    @Column(name = "restaurant_address")
    private String address;


    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY, mappedBy = "restaurant")
    @ToString.Exclude
    private List<TableAvailability> tableList=new ArrayList<>();

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY, mappedBy = "restaurant")
    @ToString.Exclude
    private List<Rate> rateList=new ArrayList<>();





    
}

