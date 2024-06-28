package com.role.Role.repository;

import com.role.Role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,String> {

    List<Role> findByUserId(String userId);
List<Role> findByRole(String role);
    List<Role> findByRoleId(String roleId);
List<Role> findByRoleIdAndRole(String role,String roleId);



}
