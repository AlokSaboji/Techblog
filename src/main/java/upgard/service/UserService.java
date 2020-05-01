package upgard.service;

import org.springframework.stereotype.Service;
import upgard.Model.User;
@Service
public class UserService {

    public boolean checkUser(User user){
        if(user.getUsername().equals("alok")){
            return true;
        }
        else
            return false;
    }
}
