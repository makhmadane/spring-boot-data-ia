package sn.ia.gestion_assurance.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.ia.gestion_assurance.dto.request.TypeRequest;
import sn.ia.gestion_assurance.entity.Type;
import sn.ia.gestion_assurance.exception.ResourceNotFoundException;
import sn.ia.gestion_assurance.repository.TypeRepository;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Page<Type> findAll(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    public Type findById(Long id) {
        return typeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type introuvable avec id " + id));
    }

    @Transactional
    public Type create(TypeRequest request) {
        Type type = new Type();
        type.setLibelle(request.getLibelle());
        return typeRepository.save(type);
    }

    @Transactional
    public Type update(Long id, TypeRequest request) {
        Type type = findById(id);
        type.setLibelle(request.getLibelle());
        return typeRepository.save(type);
    }

    @Transactional
    public void delete(Long id) {
        if (!typeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Type introuvable avec id " + id);
        }
        typeRepository.deleteById(id);
    }
}
