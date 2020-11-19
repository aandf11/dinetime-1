package se452.group5.dinetime.model;
import java.util.List;

public interface IBAccountServise {
    public List<BusinessAccount> findAll();

    public BusinessAccount update(BusinessAccount account);

    public BusinessAccount findById(Integer id);

    public void deleteById(Integer id);

    public List<BusinessAccount> findByName(String name);

    public List<BusinessAccount> findByPassword(String name);

    public List<BusinessAccount> findByUserId(String userId);
}
