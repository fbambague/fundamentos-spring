package com.fundamentos.springboot.fundamentos.service;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users){
        users.stream()
                .peek(user -> LOG.info("User Saved!!: "+user))
//                .forEach(user -> userRepository.save(user));
                .forEach(userRepository::save); //Metodo a partir de ref
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User SaveUser(User user){
        return userRepository.save(user);
    }

    public void DeleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(User user, Long id){

        return this.userRepository.findById(id)
                .map(user1 -> {
                    user1.setEmail(user.getEmail());
                    user1.setDob(user.getDob());
                    user1.setName(user.getName());
                    return userRepository.save(user1);
                }).get();

        //return userRepository.save(user);
    }

}
