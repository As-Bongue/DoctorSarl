package com.doctorsarl.doctorsarl.services.services_implement;

import com.doctorsarl.doctorsarl.entities.Role;
import com.doctorsarl.doctorsarl.repository.RoleRepository;
import com.doctorsarl.doctorsarl.services.interface_services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role saveRole(Role r) {
        return roleRepository.save(r);
    }

    @Override
    public Role updateRole(Role r) {
        return roleRepository.save(r);
    }

    @Override
    public void deleteRole(Role r) {
        roleRepository.delete(r);
    }

    @Override
    public void deleteRoleById(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role getRole(int id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
}
