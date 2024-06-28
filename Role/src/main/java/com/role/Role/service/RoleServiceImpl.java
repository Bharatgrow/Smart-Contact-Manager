package com.role.Role.service;

import com.role.Role.entity.Role;
import com.role.Role.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RoleServiceImpl implements RoleService{


    @Autowired
    private RoleRepository roleRepository;



    @Override
    public Role create(Role role) {
        List<Role> roled=roleRepository.findByRole(role.getRole());
if(roled.isEmpty()){
    String roleId=UUID.randomUUID().toString();
    role.setRoleId(roleId);

} else {
    role.setRoleId(roled.get(0).getRoleId());

}


        return roleRepository.save(role);
    }

    @Override
    public List<Role> findByUserId(String userId) {

        return roleRepository.findByUserId(userId);
    }

    @Override
    public List<Role> findByRole(String role) {

        return roleRepository.findAll();
    }

    @Override
    public List<Role> findByRoleId(String roleId) {
        return roleRepository.findByRoleId(roleId);
    }

    @Override
    public List<Role> findByRoleIdAndRole(String role, String roleId) {
        List<Role> rolesToUpdate = roleRepository.findByRoleId(roleId);

        for (Role roles : rolesToUpdate) {
            roles.setRole(role); // Set the new role value
        }

        return roleRepository.saveAll(rolesToUpdate);
    }

    //    @Override
//    public List<Role> findByRoleId(String roleId) {
//        List<Role> update=roleRepository.findByRoleId(role.getRole());
//
//        role.setRole(update.toString());
//        return  roleRepository.findByRoleId(roleId);
//    }
//@Override
//public List<Role> findByRoleId(String roleId,String role) {
//    List<Role> update=roleRepository.findByRoleId(roleId);
//
//    role.setRole(update.toString());
//    return  roleRepository.save(role);
//}






}
