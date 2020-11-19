package se452.group5.dinetime.model;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;


@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class RestaurantService implements IRestaurantService{
    @Autowired
    private RestaurantRepository repository;
  
    @Override
    public List<Restaurant> findAll() {
      System.out.println("finall size:"+repository.findAll().size());
      return repository.findAll();
    }
  
    @Override
    public Restaurant update(Restaurant restaurant) {
      System.out.println("update");
      repository.save(restaurant);
      return restaurant;
    }
  
    @Override
    public Restaurant findById(Integer id) {
      return repository.findById(id).get();
      // return null;
    }
  
 
    @Override
    public void deleteById(Integer id) {
      System.out.println("Delete by id :"+ id);
      repository.deleteById(id);
    }
}
