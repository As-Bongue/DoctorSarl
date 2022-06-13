package com.doctorsarl.doctorsarl.services.services_implement;

import com.doctorsarl.doctorsarl.entities.Service;
import com.doctorsarl.doctorsarl.repository.ServiceRepository;
import com.doctorsarl.doctorsarl.services.interface_services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Inheritance;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Service saveService(Service s) {
        return serviceRepository.save(s);
    }

    @Override
    public Service updateService(Service s) {
        return serviceRepository.save(s);
    }

    @Override
    public void deleteService(Service s) {
        serviceRepository.delete(s);
    }

    @Override
    public void deleteById(int id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Service getService(int id) {
        return serviceRepository.findById(id).get();
    }

    @Override
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }
}
