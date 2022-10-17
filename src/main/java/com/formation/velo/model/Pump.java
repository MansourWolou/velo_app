package com.formation.velo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "pump")
public class Pump {
    private static final long serialVersionUID = -767070904974486420L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ville;
    private String pop;
    private String regName;
    private String comArmCode;
    private String depName;
    private String prixNom;
    private String comCode;
    private String epciName;
    private String depCode;
    private String prixID;
    private String servicesService;
    private String horairesAutomate24_24;
    private String comArmName;
    private Date prixMaj;
    private String pumpId;
    private String regCode;
    private String adresse;
    private double[] geom;
    private String epciCode;
    private String cp;
    private double prixValeur;
    private String comName;

}
