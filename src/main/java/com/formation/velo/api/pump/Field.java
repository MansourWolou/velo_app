package com.formation.velo.api.pump;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Field {
    private String ville;
    private String pop;
    @SerializedName("available_bike_stands")
    private String regName;
    @SerializedName("available_bike_stands")
    private String comArmCode;
    @SerializedName("available_bike_stands")
    private String depName;
    @SerializedName("available_bike_stands")
    private String prixNom;
    @SerializedName("available_bike_stands")
    private String comCode;
    @SerializedName("available_bike_stands")

    private String epciName;
    @SerializedName("available_bike_stands")
    private String depCode;
    @SerializedName("available_bike_stands")
    private String prixID;
    @SerializedName("available_bike_stands")

    private String servicesService;
    @SerializedName("available_bike_stands")
    private String horairesAutomate24_24;
    @SerializedName("available_bike_stands")
    private String comArmName;
    private Date prixMaj;
    private String pumpId;
    @SerializedName("available_bike_stands")

    private String regCode;
    private String adresse;
    private double[] geom;
    @SerializedName("available_bike_stands")
    private String epciCode;
    private String cp;
    @SerializedName("available_bike_stands")
    private double prixValeur;
    private String comName;

}
