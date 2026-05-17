package sn.ia.gestion_assurance.entity;

import jakarta.persistence.*;

@Entity
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto -incremement
    protected Long id;

    @Column(length = 50, name = "nom")
    protected String nomClient;

    @Column
    protected String numero;

    @Column
    protected double montant;
}
