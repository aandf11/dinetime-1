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
@Table(name="rates")
public class Rate {
    
    @Column
    @Id
    @GeneratedValue
    private long id;

    // @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    // @JoinColumn(name = "CustomerAccount")
    // private CustomerAccount customerAccount;

    @ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private CustomerAccount user_id;

  
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "rate_detail")
    // private RateDetail rateDetail;


    private String star;

    // private String restaurant;

    @ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
    @JoinColumn(name = "restaurants")
    private Restaurant restaurant;
    
    



    
}
