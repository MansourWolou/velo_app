package com.formation.velo.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "station")
public class Station implements Serializable {
    private static final long serialVersionUID = -767070904974486420L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double lattitude;
    private Double longitude;
    private String status;
    private Integer bike_stands; //     poste de vélo
    private Integer available_bikes;//  vélos dispo
    private Integer available_bike_stands;//    poste de vélo dispo
    private Integer recordId;
    private String addresse;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(id, station.id) &&
                Objects.equals(lattitude, station.lattitude) &&
                Objects.equals(longitude, station.longitude) &&
                Objects.equals(status, station.status) &&
                Objects.equals(bike_stands, station.bike_stands) &&
                Objects.equals(available_bikes, station.available_bikes) &&
                Objects.equals(available_bike_stands, station.available_bike_stands) &&
                Objects.equals(recordId, station.recordId) &&
                Objects.equals(addresse, station.addresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lattitude,longitude,status,bike_stands,available_bikes,available_bike_stands,recordId,addresse);
    }



}
