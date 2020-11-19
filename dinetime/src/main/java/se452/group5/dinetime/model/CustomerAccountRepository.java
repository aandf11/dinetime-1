package se452.group5.dinetime.model;


import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, Integer> {
    List<CustomerAccount> findById(int id);

    @Override
    List<CustomerAccount> findAll();

    List<CustomerAccount> findByName(String name);

    List<CustomerAccount> findByPassword(String name);

    List<CustomerAccount> findByUserId(String userId);


}
