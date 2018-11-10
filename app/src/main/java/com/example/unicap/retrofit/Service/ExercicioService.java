package com.example.unicap.retrofit.Service;

import com.example.unicap.model.Exercicio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface ExercicioService {

    @GET("exercicio/listar")
    Call<List<Exercicio>> GetExercicios();

    @PUT("/exercicio/avaliacao")
    Call<Exercicio> atualizarExercicio(@Body Exercicio e);

}
