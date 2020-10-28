package se452.group5.dinetime;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

import lombok.Data;
import se452.group5.dinetime.model.*;


@Data
@Entity
public class Rate {
    
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "CustomerAccount")
    private CustomerAccount customerAccount;

  
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rate_detail")
    private RateDetail rateDetail;


    private String restaurant_name;
    



    
}
