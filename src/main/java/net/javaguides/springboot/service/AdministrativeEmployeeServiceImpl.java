package net.javaguides.springboot.service;

import net.javaguides.springboot.model.AdministrativeEmployee;
import net.javaguides.springboot.repository.AdministrativeEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrativeEmployeeServiceImpl implements AdministrativeEmployeeService {

    @Autowired
    private AdministrativeEmployeeRepository administrativeEmployeeRepository;

    @Override
    public List<AdministrativeEmployee> getAllAdministrativeEmployees() {
        return administrativeEmployeeRepository.findAll();
    }

    @Override
    public void saveAdministrativeEmployee(AdministrativeEmployee administrativeEmployee) {
        this.administrativeEmployeeRepository.save(administrativeEmployee);
    }

    @Override
    public AdministrativeEmployee getAdministrativeEmployeeById(long id) {
        Optional<AdministrativeEmployee> optional = administrativeEmployeeRepository.findById(id);
        AdministrativeEmployee administrativeEmployee = null;
        if (optional.isPresent()) {
            administrativeEmployee = optional.get();
        } else {
            throw new RuntimeException(" Administrative employee not found for id :: " + id);
        }
        return administrativeEmployee;
    }

    @Override
    public void deleteAdministrativeEmployeeById(long id) {
        this.administrativeEmployeeRepository.deleteById(id);
    }

}
