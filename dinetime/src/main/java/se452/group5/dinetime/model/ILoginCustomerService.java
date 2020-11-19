package se452.group5.dinetime.model;
import java.util.List;


public interface ILoginCustomerService {
    public List<LoginCustomer> findAll();

    public LoginCustomer update(LoginCustomer account);

    public LoginCustomer findById(Integer id);

    public void deleteById(Integer id);

  
}
