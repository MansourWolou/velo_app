package com.formation.velo.api;

import com.formation.velo.api.velo.Field;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Record {
    @SerializedName("recordid")
    private String recordid;
    @SerializedName("fields")
    private Field field;
}
