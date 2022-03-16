package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.AdministrativeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdministrativeEmployeeRepository extends JpaRepository<AdministrativeEmployee, Long>{

}
