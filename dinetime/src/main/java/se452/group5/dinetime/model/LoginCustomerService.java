

package se452.group5.dinetime.model;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;


@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class LoginCustomerService implements ILoginCustomerService{

    @Autowired
    private LoginCustomerRepository repository;
  
    @Override
    public List<LoginCustomer> findAll() {
      System.out.println("finall size:"+repository.findAll().size());
      return repository.findAll();
    }
  
    @Override
    public LoginCustomer update(LoginCustomer loginCustomer) {
      System.out.println("update");
      repository.save(loginCustomer);
      return loginCustomer;
    }
  
    @Override
    public LoginCustomer findById(Integer id) {
      return repository.findById(id).get();
      // return null;
    }
  
    @Override
    public void deleteById(Integer id) {
      System.out.println("Delete by id :"+ id);
      repository.deleteById(id);
    }
    
}

