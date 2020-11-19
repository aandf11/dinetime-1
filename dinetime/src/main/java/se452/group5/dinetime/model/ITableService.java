package se452.group5.dinetime.model;
import java.util.List;
import java.sql.Date;

public interface ITableService {
    public List<TableAvailability> findAll();

    public TableAvailability update(TableAvailability table);

    public TableAvailability findById(Integer id);

    public void deleteById(Integer id);
    
    public List<TableAvailability> findBySeats(int seats);

    public List<TableAvailability> findBySeatsInAndDateIn(List<Integer> seats, List<Date> date);

    public List<TableAvailability> findBySeatsInAndDateInAndAvailableIn(List<Integer> seats, List<Date> date, List<Boolean> available);

}
