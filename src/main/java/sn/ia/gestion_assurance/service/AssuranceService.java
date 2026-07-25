package sn.ia.gestion_assurance.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.ia.gestion_assurance.dto.request.AssuranceRequest;
import sn.ia.gestion_assurance.entity.Assurance;
import sn.ia.gestion_assurance.entity.Type;
import sn.ia.gestion_assurance.exception.ResourceNotFoundException;
import sn.ia.gestion_assurance.repository.AssuranceRepository;
import sn.ia.gestion_assurance.repository.TypeRepository;

@Service
public class AssuranceService {

    private final AssuranceRepository assuranceRepository;
    private final TypeRepository typeRepository;

    public AssuranceService(AssuranceRepository assuranceRepository, TypeRepository typeRepository) {
        this.assuranceRepository = assuranceRepository;
        this.typeRepository = typeRepository;
    }

    public Page<Assurance> findAll(Pageable pageable) {
        return assuranceRepository.findAll(pageable);
    }

    public Assurance findById(Long id) {
        return assuranceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assurance introuvable avec id " + id));
    }

    @Transactional
    public Assurance create(AssuranceRequest request) {
        Assurance assurance = new Assurance();
        assurance.setNomClient(request.getNomClient());
        assurance.setNumero(request.getNumero());
        assurance.setMontant(request.getMontant());
        assurance.setType(resolveType(request.getTypeId()));
        return assuranceRepository.save(assurance);
    }

    @Transactional
    public Assurance update(Long id, AssuranceRequest request) {
        Assurance assurance = findById(id);
        assurance.setNomClient(request.getNomClient());
        assurance.setNumero(request.getNumero());
        assurance.setMontant(request.getMontant());
        assurance.setType(resolveType(request.getTypeId()));
        return assuranceRepository.save(assurance);
    }

    @Transactional
    public void delete(Long id) {
        if (!assuranceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Assurance introuvable avec id " + id);
        }
        assuranceRepository.deleteById(id);
    }

    private Type resolveType(Long typeId) {
        if (typeId == null) {
            return null;
        }
        return typeRepository.findById(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Type introuvable avec id " + typeId));
    }
}
