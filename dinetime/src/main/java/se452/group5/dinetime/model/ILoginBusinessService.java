package se452.group5.dinetime.model;
import java.util.List;

public interface ILoginBusinessService {
    public List<LoginBusiness> findAll();

    public LoginBusiness update(LoginBusiness account);

    public LoginBusiness findById(Integer id);

    public void deleteById(Integer id);
}
