package com.example.unicap.fono;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.unicap.retrofit.Config.RetrofitConfig;
import com.example.unicap.model.Licao;
import com.example.unicap.model.Paciente;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LicaoActivity extends AppCompatActivity {

    List<Licao> listLicoes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_licoes);

        Paciente p = null;

        Bundle bundle = getIntent().getExtras();

        if ( bundle != null ){
            p = (Paciente) bundle.getSerializable("ObjLicao");

        }

        final Paciente paciente = p;

        ListView listView;


        listView = findViewById(R.id.listViewLicao);

       // listView.setAdapter(new LicaoAdapter(this, carregarLicoes(),));


        //listView.setAdapter(new LicaoAdapter(this, carregarLicoes()));


    }


    public List<Licao> carregarLicoes(){


        Call<List<Licao>> call = new RetrofitConfig().getLicoesService().GetLicoes();


        call.enqueue(new Callback<List<Licao>>() {
            @Override
            public void onResponse(Call<List<Licao>> call, Response<List<Licao>> response) {
                listLicoes = (List<Licao>) response.body().get(0);
            }

            @Override
            public void onFailure(Call<List<Licao>> call, Throwable t) {


            }
        });

        return listLicoes;


    }


}
