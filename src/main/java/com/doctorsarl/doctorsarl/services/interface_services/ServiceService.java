package com.doctorsarl.doctorsarl.services.interface_services;

import com.doctorsarl.doctorsarl.entities.Service;

import java.util.List;

public interface ServiceService {

    Service saveService(Service s);
    Service updateService(Service s);
    void deleteService(Service s);
    void deleteById(int id);
    Service getService(int id);
    List<Service> getAllServices();
    void addServiceToDossier(String nom, String code);
}
