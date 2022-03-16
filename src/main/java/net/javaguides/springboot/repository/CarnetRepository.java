package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Carnet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarnetRepository extends JpaRepository<Carnet, Long>{

}

