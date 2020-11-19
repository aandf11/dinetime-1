package se452.group5.dinetime.model;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class TableAvailabilityService implements ITableService {

  @Autowired
  private TableAvailabilityRepository repository;

  @Override
  public List<TableAvailability> findAll() {
    System.out.println("finall size:" + repository.findAll().size());
    return repository.findAll();
  }

  @Override
  public TableAvailability update(TableAvailability table) {
    System.out.println("update");
    repository.save(table);
    return table;
  }

  @Override
  public TableAvailability findById(Integer id) {
    return repository.findById(id).get();
    // return null;
  }

  @Override
  public void deleteById(Integer id) {
    System.out.println("Delete by id :" + id);
    repository.deleteById(id);
  }

  // public CustomerAccount findByUserId(String userId) {
  // return repository.findByUserId(userId).get(0);
  // // return null;
  // }

  @Override
  public List<TableAvailability> findBySeats(int seats) {

    return repository.findBySeats(seats);

  }

  @Override
  public List<TableAvailability> findBySeatsInAndDateIn(List<Integer> seats, List<Date> date) {
    return repository.findBySeatsInAndDateIn(seats, date);
  }
  @Override
  public List<TableAvailability> findBySeatsInAndDateInAndAvailableIn(List<Integer> seats, List<Date> date, List<Boolean> available){
    return repository.findBySeatsInAndDateInAndAvailableIn(seats, date, available);
  }



 
    
}
