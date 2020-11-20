package se452.group5.dinetime.model;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;


@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class ReservationService implements IReservationService{

    @Autowired
    private ReservationRepository repository;
  
    @Override
    public List<Reservation> findAll() {
      System.out.println("finall size:"+repository.findAll().size());
      return repository.findAll();
    }
  
    @Override
    public Reservation update(Reservation reservation) {
      System.out.println("update");
      repository.save(reservation);
      return reservation;
    }
  
    @Override
    public Reservation findById(Integer id) {
      return repository.findById(id).get();
   
    }
  
    @Override
    public void deleteById(Integer id) {
      System.out.println("Delete by id :"+ id);
      repository.deleteById(id);
      repository.deleteAll();
    }

    @Override
    public List<Reservation> findByRestaurant(String name){
      System.out.println("find by name :"+ name);
      return repository.findByRestaurant(name);
    }
    
}
