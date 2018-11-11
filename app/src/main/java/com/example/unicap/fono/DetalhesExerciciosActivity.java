package com.example.unicap.fono;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unicap.adapter.AtividadeAdapter;
import com.example.unicap.adapter.AudioAdapter;
import com.example.unicap.model.Atividade;
import com.example.unicap.model.Exercicio;
import com.example.unicap.model.Paciente;
import com.example.unicap.retrofit.Config.RetrofitConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalhesExerciciosActivity extends AppCompatActivity {


    private Paciente paciente;
    private int AtividadeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_detalhes_atividade);


        Bundle extra = getIntent().getExtras();
        if(extra != null) {
            AtividadeId = (int) extra.getSerializable("AtividadeId");
            paciente = (Paciente) extra.getSerializable("Paciente");

            //Paciente
        }

        Call<Atividade> call = new RetrofitConfig().getAtividadeService().AtividadeById(AtividadeId);

        call.enqueue(new Callback<Atividade>() {
            @Override
            public void onResponse(@NonNull Call<Atividade> call, @NonNull Response<Atividade> response) {

                Atividade atividade = response.body();

                TextView nomeLicao = findViewById(R.id.textView3);
                TextView descricao = findViewById(R.id.textView);
                ListView listView = findViewById(R.id.listGravacao);

                nomeLicao.setText(atividade.getLicao().getNome());
                descricao.setText(atividade.getLicao().getDescricao());
                listView.setAdapter(new AudioAdapter(getApplicationContext(), atividade.getExercicios() ,atividade));

            }

            @Override
            public void onFailure(@NonNull Call<Atividade> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }



    public void onBackPressed(){


        Intent i = new Intent(getApplicationContext(),AtividadesActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("Paciente", paciente);
        getApplicationContext().startActivity(i);

    }



}