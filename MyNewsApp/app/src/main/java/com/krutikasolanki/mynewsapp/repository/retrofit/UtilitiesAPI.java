package com.krutikasolanki.mynewsapp.repository.retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UtilitiesAPI {
    private static Retrofit retrofit;

    public static InterfaceAPI getAPIInterface() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(InterfaceAPI.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(InterfaceAPI.class);
    }
}
