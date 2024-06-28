package com.microservices.microservices.ExtraService;

import com.microservices.microservices.Entity.Role;
import com.microservices.microservices.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RoleService {


     List<Role> getAll();


     Role getById(int roleId);


     Role saveAll(Role role);

}
