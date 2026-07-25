package sn.ia.gestion_assurance.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AssuranceRequest {

    @NotBlank(message = "Le nom du client est obligatoire")
    private String nomClient;

    @NotBlank(message = "Le numéro est obligatoire")
    private String numero;

    @Positive(message = "Le montant doit être positif")
    private double montant;

    private Long typeId;
}
