package com.paul.security.user_security.service;

import com.paul.security.user_security.dao.UserTableRepo;
import com.paul.security.user_security.model.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserTableRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("UserName is "+username);
        UserTable user = userRepo.findById(username).orElseThrow();

        return new UserPrincipal(user);
    }
}
