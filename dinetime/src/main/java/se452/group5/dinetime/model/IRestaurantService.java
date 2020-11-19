package se452.group5.dinetime.model;
import java.util.List;

public interface IRestaurantService{
    public List<Restaurant> findAll();

    public Restaurant update(Restaurant restaurant);

    public Restaurant findById(Integer id);

    public void deleteById(Integer id);
}
