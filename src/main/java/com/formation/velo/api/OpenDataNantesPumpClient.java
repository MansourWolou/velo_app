package com.formation.velo.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OpenDataNantesPumpClient {
    @GET("/api/records/1.0/search/?dataset=prix-carburants-fichier-instantane-test-ods-copie&q=nantes&facet=id&facet=adresse&facet=ville&facet=prix_maj&facet=prix_nom&facet=com_arm_name&facet=epci_name&facet=dep_name&facet=reg_name&facet=services_service&facet=horair")
    Call<OpenData> getRecords();
}
