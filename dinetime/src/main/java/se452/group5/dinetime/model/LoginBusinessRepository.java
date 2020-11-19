package se452.group5.dinetime.model;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface LoginBusinessRepository extends CrudRepository<LoginBusiness, Integer> {
    List<LoginBusiness> findById(int id);

    @Override
    List<LoginBusiness> findAll();
    
}
