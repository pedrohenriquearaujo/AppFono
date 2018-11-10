package com.example.unicap.retrofit.Service;

import com.example.unicap.model.Paciente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PacienteService {

    @GET("paciente/listar")
    Call<List<Paciente>> GetPacientes();

}
