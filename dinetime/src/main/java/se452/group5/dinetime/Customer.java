package se452.group5.dinetime;

import java.sql.Date;
import lombok.Data;

@Data
public class Customer {

    private long id;

    private String name;
    
    private String email;

    private Date datesignedup;
}