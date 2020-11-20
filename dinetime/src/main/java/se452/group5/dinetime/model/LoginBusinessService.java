

package se452.group5.dinetime.model;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;


@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class LoginBusinessService implements ILoginBusinessService{

    @Autowired
    private LoginBusinessRepository repository;
  
    @Override
    public List<LoginBusiness> findAll() {
      System.out.println("finall size:"+repository.findAll().size());
      return repository.findAll();
    }
  
    @Override
    public LoginBusiness update(LoginBusiness loginBusiness) {
      System.out.println("update");
      repository.save(loginBusiness);
      return loginBusiness;
    }
  
    @Override
    public LoginBusiness findById(Integer id) {
      return repository.findById(id).get();
    }
  
    @Override
    public void deleteById(Integer id) {
      System.out.println("Delete by id :"+ id);
      repository.deleteById(id);
    }
    
}
