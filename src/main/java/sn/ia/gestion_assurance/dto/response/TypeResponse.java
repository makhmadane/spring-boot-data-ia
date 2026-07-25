package sn.ia.gestion_assurance.dto.response;

import lombok.Data;
import sn.ia.gestion_assurance.entity.Type;

@Data
public class TypeResponse {

    private Long id;
    private String libelle;

    public static TypeResponse from(Type type) {
        TypeResponse response = new TypeResponse();
        response.setId(type.getId());
        response.setLibelle(type.getLibelle());
        return response;
    }
}
