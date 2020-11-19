package se452.group5.dinetime.model;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>{
    List<Restaurant> findById(int id);

    @Override
    List<Restaurant> findAll();
    
}
