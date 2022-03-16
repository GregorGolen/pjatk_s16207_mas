package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.LeaseUsed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LeaseRepository extends JpaRepository<LeaseUsed, Long>{

}
