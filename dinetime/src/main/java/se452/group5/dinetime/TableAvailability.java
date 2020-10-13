package se452.group5.dinetime;

import java.security.Principal;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

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


    private boolean available;

    private int seats;

    private String time;

    private Date date;
}
