package se452.group5.dinetime.model;


import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
    List<Reservation> findById(int id);

    @Override
    List<Reservation> findAll();

    

    List<Reservation> findByRestaurant(String name);
    
}
