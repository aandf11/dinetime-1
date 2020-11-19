package se452.group5.dinetime.model;
import java.util.List;

public interface IRateService {
    public List<Rate> findAll();

    public Rate update(Rate rate);

    public Rate findById(Integer id);

    public void deleteById(Integer id);
}
