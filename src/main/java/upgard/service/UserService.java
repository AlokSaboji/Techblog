package upgard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upgard.Model.User;
import upgard.repository.UserRepository;

import javax.persistence.EntityManager;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User checkUser(User user){
        if(user.getPassword().equals(userRepository.getUser(user).getPassword())){
            User existingUser  = userRepository.getUser(user);
            return existingUser;
        }
        else
            return null;
    }

    public void registerUser(User user){
        userRepository.registerUser(user);
    }
}
