package com.role.Role.service;

import com.role.Role.entity.Role;

import java.util.List;

public interface RoleService {

    Role create(Role role);

    List<Role> findByUserId(String userId);

    List<Role> findByRole(String role);

    List<Role> findByRoleId(String roleId);

    List<Role> findByRoleIdAndRole(String role,String roleId);





}
