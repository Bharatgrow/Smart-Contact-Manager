package com.microservices.microservices.ExtraService;

import com.microservices.microservices.Entity.Role;
import com.microservices.microservices.Entity.User;
import com.microservices.microservices.Repository.RoleRepository;
import com.microservices.microservices.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(int roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

    @Override
    public Role saveAll(Role role) {

        System.out.println();

        role.setUsers(userRepository.findAll());
        return roleRepository.save(role);

    }
}
