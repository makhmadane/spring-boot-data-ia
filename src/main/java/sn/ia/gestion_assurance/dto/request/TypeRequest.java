package sn.ia.gestion_assurance.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TypeRequest {

    @NotBlank(message = "Le libellé est obligatoire")
    private String libelle;
}
