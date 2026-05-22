package sn.ia.gestion_assurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.ia.gestion_assurance.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
