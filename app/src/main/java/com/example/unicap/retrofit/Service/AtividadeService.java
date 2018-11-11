package com.example.unicap.retrofit.Service;


import com.example.unicap.model.Atividade;
import com.example.unicap.model.Exercicio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AtividadeService {

    @GET("atividade/paciente-id/{id}")
    Call<List<Atividade>> listarAtividade(@Path("id") int id);

    @POST("atividade")
    Call<Atividade> cadastrarAtividade(@Body Atividade a);

    @GET("atividade/{id}")
    Call<Atividade> AtividadeById(@Path("id") int id);


}
