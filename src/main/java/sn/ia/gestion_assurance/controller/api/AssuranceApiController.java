package sn.ia.gestion_assurance.controller.api;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sn.ia.gestion_assurance.dto.request.AssuranceRequest;
import sn.ia.gestion_assurance.dto.response.AssuranceResponse;
import sn.ia.gestion_assurance.entity.Assurance;
import sn.ia.gestion_assurance.service.AssuranceService;

import java.net.URI;

@RestController
@RequestMapping("/api/assurances")
public class AssuranceApiController {

    private final AssuranceService assuranceService;

    public AssuranceApiController(AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    @GetMapping
    public Page<AssuranceResponse> findAll(Pageable pageable) {
        return assuranceService.findAll(pageable).map(AssuranceResponse::from);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssuranceResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(AssuranceResponse.from(assuranceService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<AssuranceResponse> create(@Valid @RequestBody AssuranceRequest request) {
        Assurance created = assuranceService.create(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(AssuranceResponse.from(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssuranceResponse> update(@PathVariable Long id, @Valid @RequestBody AssuranceRequest request) {
        return ResponseEntity.ok(AssuranceResponse.from(assuranceService.update(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        assuranceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
