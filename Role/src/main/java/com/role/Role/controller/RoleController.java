package com.role.Role.controller;

import com.role.Role.entity.Role;
import com.role.Role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role role){
        return  ResponseEntity.status(HttpStatus.CREATED).body(roleService.create(role));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Role>> getByUserId(@PathVariable String userId){


        return ResponseEntity.ok(roleService.findByUserId(userId));
    }

    @PostMapping("/{roleId}/{role}")
    public List<Role> updateRolesByRoleId(  @PathVariable String roleId,@PathVariable String role) {
        return roleService.findByRoleIdAndRole(role, roleId);
    }



}
