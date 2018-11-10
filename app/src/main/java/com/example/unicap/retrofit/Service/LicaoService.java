package com.example.unicap.retrofit.Service;

import com.example.unicap.model.Licao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LicaoService {

    @GET("licao/listar")
    Call<List<Licao>> GetLicoes();

}
