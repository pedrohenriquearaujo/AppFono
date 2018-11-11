package com.example.unicap.fono;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unicap.adapter.PacienteAdapter;
import com.example.unicap.retrofit.Config.RetrofitConfig;
import com.example.unicap.model.Paciente;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PacientesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pacientes);

        Call<List<Paciente>> call = new RetrofitConfig().getPacienteService().GetPacientes();

        call.enqueue(new Callback<List<Paciente>>() {
            @Override
            public void onResponse(@NonNull Call<List<Paciente>> call, @NonNull Response<List<Paciente>> response) {

                List<Paciente> listPacientes = response.body();

                ListView listView = findViewById(R.id.listViewPaciente);

                listView.setAdapter(new PacienteAdapter(getApplication(),listPacientes));

            }

            @Override
            public void onFailure(@NonNull Call<List<Paciente>> call, Throwable t) {
                Toast.makeText(PacientesActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });





    }

    public void onBackPressed()
    {

    }

}
