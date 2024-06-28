package com.microservices.microservices.Controller;

import com.microservices.microservices.Entity.Role;
import com.microservices.microservices.ExtraService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAll(){
       return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Role getById(int roleId){
        return roleService.getById(roleId);
    }

    @PostMapping
    public Role save(@RequestBody Role role){

        return roleService.saveAll(role);
    }

}
