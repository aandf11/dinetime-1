package se452.group5.dinetime.model;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;


@Service
@ConditionalOnProperty(name = "datasource", havingValue = "db")
public class CustomerAccountService implements IAccountServise{
    
  @Autowired
  private CustomerAccountRepository repository;

  @Override
  public List<CustomerAccount> findAll() {
    System.out.println("finall size:"+repository.findAll().size());
    return repository.findAll();
  }

  @Override
  public CustomerAccount update(CustomerAccount account) {
    System.out.println("update in servise " + account.getReservationList());
    repository.save(account);
    
    return account;
  }

  @Override
  public CustomerAccount findById(Integer id) {
    return repository.findById(id).get();
    // return null;
  }

  // public CustomerAccount findByUserId(String userId) {
  //   return repository.findByUserId(userId).get(0);
  //   // return null;
  // }

  @Override
  public void deleteById(Integer id) {
    System.out.println("Delete by id :"+ id);
    repository.deleteById(id);
  }

  @Override
  public List<CustomerAccount> findByName(String name){
    return repository.findByName(name);
  }

  @Override
  public List<CustomerAccount> findByPassword(String password){
    return repository.findByPassword(password);
  }

  @Override

  public List<CustomerAccount> findByUserId(String userId){
    return repository.findByUserId(userId);
  }




}
