package sn.ia.gestion_assurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.ia.gestion_assurance.entity.Assurance;

@Repository
public interface AssuranceRepository extends JpaRepository<Assurance, Long> {


}
