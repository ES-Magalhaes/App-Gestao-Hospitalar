package com.edu.fatec.appgestaohospitalar.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    // SE FOR EMULADOR: 10.0.2.2 | SE FOR CELULAR REAL: IP do seu PC (ex: 192.168.x.x)
    private static final String BASE_URL = "http://192.168.100.123:8080/";
    private static Retrofit retrofit = null;

    public static ApiService getApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiService.class);
    }
}
