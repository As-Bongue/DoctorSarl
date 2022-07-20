package com.doctorsarl.doctorsarl.services.interface_services;

import com.doctorsarl.doctorsarl.entities.Role;

import java.util.List;

public interface RoleService {
    Role saveRole(Role r);
    Role updateRole(Role r);
    void deleteRole(Role r);
    void deleteRoleById(int id);
    Role getRole(int id);
    List<Role> getAllRole();
}
