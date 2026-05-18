package com.edu.fatec.appgestaohospitalar.model;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("api/medicos")
    Call<List<Medico>> getMedicos();

    @POST("api/medicos")
    Call<Medico> addMedico(@Body Medico medico);
}
