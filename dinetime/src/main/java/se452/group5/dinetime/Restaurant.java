package se452.group5.dinetime;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

import javax.persistence.Column;

import javax.persistence.FetchType;



@Data
@Entity
public class Restaurant {
    
    @Column
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String location_id; 

    
    @OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY, mappedBy = "restaurant")
    @ToString.Exclude
    private List<TableAvailability> tableList=new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurants_detail")
    private RestaurantDetail restaurantDetail;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurants_location")
    private RestaurantLocation restaurantLocation;



    
}

