package se452.group5.dinetime;

import java.util.List;
import lombok.Data;

@Data
public class wait_List {
    private String resteraunt;
    private List<Customer> wait_queue;
    
}