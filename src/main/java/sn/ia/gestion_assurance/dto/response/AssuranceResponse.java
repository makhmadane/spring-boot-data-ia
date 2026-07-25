package sn.ia.gestion_assurance.dto.response;

import lombok.Data;
import sn.ia.gestion_assurance.entity.Assurance;

@Data
public class AssuranceResponse {

    private Long id;
    private String nomClient;
    private String numero;
    private double montant;
    private TypeResponse type;

    public static AssuranceResponse from(Assurance assurance) {
        AssuranceResponse response = new AssuranceResponse();
        response.setId(assurance.getId());
        response.setNomClient(assurance.getNomClient());
        response.setNumero(assurance.getNumero());
        response.setMontant(assurance.getMontant());
        if (assurance.getType() != null) {
            response.setType(TypeResponse.from(assurance.getType()));
        }
        return response;
    }
}
