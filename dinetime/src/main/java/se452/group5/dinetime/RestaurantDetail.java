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

@Data
@Entity
public class RestaurantDetail {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "restaurantDetail")
    private Restaurant restaurant;
    

    private String business_nm;

    private String restaurants_type;

    private int average_rate;


}
