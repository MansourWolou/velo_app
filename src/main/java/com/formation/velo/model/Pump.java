package com.formation.velo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "pump")
public class Pump implements Serializable {
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
    private Double latitude;
    private Double longitude;
    private String epciCode;
    private String cp;
    private double prixValeur;
    private String comName;
    private String recordId;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pump pump = (Pump) o;
        return Objects.equals(id,pump.id)&&
                Objects.equals(ville, pump.ville) &&
                Objects.equals(pop, pump.pop) &&
                Objects.equals(regName, pump.regName) &&
                Objects.equals(comArmCode, pump.comArmCode) &&
                Objects.equals(depName, pump.depName) &&
                Objects.equals(prixNom, pump.prixNom) &&
                Objects.equals(comCode, pump.comCode) &&
                Objects.equals(epciName, pump.epciName) &&
                Objects.equals(depCode, pump.depCode) &&
                Objects.equals(prixID, pump.prixID) &&
                Objects.equals(servicesService, pump.servicesService) &&
                Objects.equals(horairesAutomate24_24, pump.horairesAutomate24_24) &&
                Objects.equals(comArmName, pump.comArmName) &&
                Objects.equals(prixMaj, pump.prixMaj) &&
                Objects.equals(pumpId, pump.pumpId) &&
                Objects.equals(regCode, pump.regCode) &&
                Objects.equals(adresse, pump.adresse) &&
                Objects.equals(latitude, pump.latitude) &&
                Objects.equals(longitude, pump.longitude) &&
                Objects.equals(epciCode, pump.epciCode) &&
                Objects.equals(cp, pump.cp) &&
                Objects.equals(prixValeur, pump.prixValeur) &&
                Objects.equals(comName, pump.comName) &&
                Objects.equals(recordId, pump.recordId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                ville,
                pop,
                regName,
                comArmCode,
                depName,
                prixNom,
                comCode,
                epciName,
                depCode,
                prixID,
                servicesService,
                horairesAutomate24_24,
                comArmName,
                prixMaj,
                pumpId,
                regCode,
                adresse,
                latitude,
                longitude,
                epciCode,
                cp,
                prixValeur,
                comName);
    }

}
