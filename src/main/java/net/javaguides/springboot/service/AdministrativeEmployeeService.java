package net.javaguides.springboot.service;

import net.javaguides.springboot.model.AdministrativeEmployee;

import java.util.List;


public interface AdministrativeEmployeeService {
    List<AdministrativeEmployee> getAllAdministrativeEmployees();
    void saveAdministrativeEmployee(AdministrativeEmployee administrativeEmployee);
    AdministrativeEmployee getAdministrativeEmployeeById(long id);
    void deleteAdministrativeEmployeeById(long id);
}

