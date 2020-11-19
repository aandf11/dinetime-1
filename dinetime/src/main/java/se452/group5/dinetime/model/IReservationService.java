package se452.group5.dinetime.model;
import java.util.List;

public interface IReservationService {
    public List<Reservation> findAll();

    public Reservation update(Reservation reservation);

    public Reservation findById(Integer id);

    public void deleteById(Integer id);

    // public List<TableAvailability> findBySeats(int seats);
    public List<Reservation> findByRestaurant(String name);
    
}
