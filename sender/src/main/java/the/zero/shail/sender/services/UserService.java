package the.zero.shail.sender.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import the.zero.shail.sender.models.UserModel;
import the.zero.shail.sender.repositories.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    public UserModel findById(int id){
        return userRepository.findById(id).orElse(new UserModel());
    }
}
