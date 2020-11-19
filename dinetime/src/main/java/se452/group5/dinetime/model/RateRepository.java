package se452.group5.dinetime.model;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
public interface RateRepository extends CrudRepository<Rate, Integer> {
    List<Rate> findById(int id);

    @Override
    List<Rate> findAll();

}
