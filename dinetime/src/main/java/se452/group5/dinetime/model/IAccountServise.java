package se452.group5.dinetime.model;
import java.util.List;



public interface IAccountServise {

    public List<CustomerAccount> findAll();

    public CustomerAccount update(CustomerAccount account);

    public CustomerAccount findById(Integer id);

    public void deleteById(Integer id);

    public List<CustomerAccount> findByName(String name);

    public List<CustomerAccount> findByPassword(String name);

    public List<CustomerAccount> findByUserId(String userId);
    
}
