package sn.ia.gestion_assurance.controller.api;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sn.ia.gestion_assurance.dto.request.TypeRequest;
import sn.ia.gestion_assurance.dto.response.TypeResponse;
import sn.ia.gestion_assurance.entity.Type;
import sn.ia.gestion_assurance.service.TypeService;

import java.net.URI;

@RestController
@RequestMapping("/api/types")
public class TypeApiController {

    private final TypeService typeService;

    public TypeApiController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public Page<TypeResponse> findAll(Pageable pageable) {
        return typeService.findAll(pageable).map(TypeResponse::from);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(TypeResponse.from(typeService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<TypeResponse> create(@Valid @RequestBody TypeRequest request) {
        Type created = typeService.create(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(TypeResponse.from(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeResponse> update(@PathVariable Long id, @Valid @RequestBody TypeRequest request) {
        return ResponseEntity.ok(TypeResponse.from(typeService.update(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        typeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
