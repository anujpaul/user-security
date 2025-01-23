package com.paul.security.user_security.service;

import com.paul.security.user_security.dao.UserTableRepo;
import com.paul.security.user_security.model.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserTableRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserTable findByUserId(String userId){
         return repo.findById(userId).orElseThrow();
     }

    public void save(List<UserTable> users) {

           users.forEach(user -> user.setPassword(encoder.encode((user.getPassword()))));
           repo.saveAll(users);
        }

    public List<UserTable> findAll() {
        List<UserTable> users = repo.findAll();

       // System.out.println(user.getUserId() + user.getPassword());
        return users;
    }

    public void delete(String userId) {
        repo.deleteById(userId);
    }
}
