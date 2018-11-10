package com.example.unicap.fono;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unicap.retrofit.Config.RetrofitConfig;
import com.example.unicap.model.Atividade;
import com.example.unicap.model.Exercicio;
import com.example.unicap.model.Paciente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalhesActivity extends AppCompatActivity {


    private Bundle extra;
    private Paciente a;
    private Atividade atividade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_detalhes_atividade);


        extra = getIntent().getExtras();
        if(extra != null) {
            a = (Paciente) extra.getSerializable("Paciente");

        }


        Call<List<Atividade>> call = new RetrofitConfig().getAtividadeService().listarAtividade(a.getId());

        call.enqueue(new Callback<List<Atividade>>() {
            @Override
            public void onResponse(Call<List<Atividade>> call, Response<List<Atividade>> response) {

                Atividade atividade = response.body().get(0);

                 List<Exercicio> exercicioList = atividade.getExercicios();



                 ListView listView = findViewById(R.id.listGravacao);

             //    listView.setAdapter(new AudioAdapter(getApplicationContext(), exercicioList));

            }

            @Override
            public void onFailure(Call<List<Atividade>> call, Throwable t) {
                Toast.makeText(DetalhesActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
