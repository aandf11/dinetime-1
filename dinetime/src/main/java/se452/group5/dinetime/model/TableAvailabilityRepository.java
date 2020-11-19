package se452.group5.dinetime.model;


import java.util.List;
import java.util.UUID;
import java.sql.Date;


import org.springframework.data.repository.CrudRepository;

public interface TableAvailabilityRepository extends CrudRepository<TableAvailability, Integer> {
    List<TableAvailability> findById(int id);

    @Override
    List<TableAvailability> findAll();

  
    List<TableAvailability> findBySeats(int seats);
    
    List<TableAvailability> findBySeatsInAndDateIn(List<Integer> seats, List<Date> date);

   List<TableAvailability> findBySeatsInAndDateInAndAvailableIn(List<Integer> seats, List<Date> date, List<Boolean> available);


}

