package com.smartcontact.smartcontactmanager.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smartcontact.smartcontactmanager.dao.UserRepository;
import com.smartcontact.smartcontactmanager.entity.User;

public class UserDetailService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
       User user= userRepository.getUserByName(username);

       if(user==null){
        throw new UsernameNotFoundException("could not found");
       }

       CustomUserDetail customUserDetail=new CustomUserDetail(user);

       return customUserDetail;

    }
    
}
