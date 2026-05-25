package com.edu.fatec.appgestaohospitalar.model;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import retrofit2.http.PUT;

public interface ApiService {
    @GET("api/medicos")
    Call<List<Medico>> getMedicos();

    @POST("api/medicos")
    Call<Medico> addMedico(@Body Medico medico);

    @DELETE("api/medicos/{id}")
    Call<Void> deleteMedico(@Path("id") int id);

    @PUT("api/medicos/{id}")
    Call<Medico> updateMedico(@Path("id") int id, @Body Medico medico);
}
