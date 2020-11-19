package se452.group5.dinetime.model;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;


@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class BusinessAccountService implements IBAccountServise {

    @Autowired
  private BusinessAccountRepository repository;

  @Override
  public List<BusinessAccount> findAll() {
    System.out.println("finall size:"+repository.findAll().size());
    return repository.findAll();
  }

  @Override
  public BusinessAccount update(BusinessAccount account) {
    System.out.println("update");
    repository.save(account);
    return account;
  }

  @Override
  public BusinessAccount findById(Integer id) {
    return repository.findById(id).get();
    // return null;
  }


  @Override
  public void deleteById(Integer id) {
    System.out.println("Delete by id :"+ id);
    repository.deleteById(id);
  }
    
  @Override
  public List<BusinessAccount> findByName(String name){
    return repository.findByName(name);
  }

  @Override
  public List<BusinessAccount> findByPassword(String password){
    return repository.findByPassword(password);
  }

  @Override

  public List<BusinessAccount> findByUserId(String userId){
    return repository.findByUserId(userId);
  }
}
