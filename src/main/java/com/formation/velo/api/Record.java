package com.formation.velo.api;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Record {
    @SerializedName("recordid")
    private String recordid;
    @SerializedName("fields")
    private Field field;
}
