package com.paul.security.user_security.service;

import com.paul.security.user_security.dao.UserTableRepo;
import com.paul.security.user_security.model.UserTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    Logger log = LoggerFactory.getLogger(MyUserDetailService.class);

    @Autowired
    private UserTableRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //This is the username which is being sent by user to authenticate
        log.info("User : {}", username);
        UserTable user = userRepo.findById(username).orElseThrow();

        return new UserPrincipal(user);
    }
}
