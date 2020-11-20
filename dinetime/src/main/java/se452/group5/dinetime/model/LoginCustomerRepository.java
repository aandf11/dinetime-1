package se452.group5.dinetime.model;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
public interface LoginCustomerRepository extends CrudRepository<LoginCustomer, Integer> {
    List<LoginCustomer> findById(int id);

    @Override
    List<LoginCustomer> findAll();
    
}

