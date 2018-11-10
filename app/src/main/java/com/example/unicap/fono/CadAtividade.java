package com.example.unicap.fono;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.unicap.adapter.LicaoAdapter;
import com.example.unicap.retrofit.Config.RetrofitConfig;
import com.example.unicap.model.Licao;
import com.example.unicap.model.Paciente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CadAtividade extends AppCompatActivity {


    private Bundle extra;
    private Paciente a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.tela_licoes);

            extra = getIntent().getExtras();
        if(extra != null) {
            a = (Paciente) extra.getSerializable("Paciente");
        }


        Call<List<Licao>> call = new RetrofitConfig().getLicoesService().GetLicoes();
        call.enqueue(new Callback<List<Licao>>() {
            @Override
            public void onResponse(Call<List<Licao>> call, Response<List<Licao>> response) {

                List<Licao> listLicoes  =  response.body();

                ListView listView = findViewById(R.id.listViewLicao);


                listView.setAdapter(new LicaoAdapter(getApplicationContext(),listLicoes, a));

            }

            @Override
            public void onFailure(Call<List<Licao>> call, Throwable t) {


            }
        });
    }
}
