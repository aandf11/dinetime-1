package se452.group5.dinetime;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, Long> {
    
}
