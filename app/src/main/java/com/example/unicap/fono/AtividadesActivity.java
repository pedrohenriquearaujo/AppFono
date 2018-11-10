package com.example.unicap.fono;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unicap.adapter.AtividadeAdapter;
import com.example.unicap.retrofit.Config.RetrofitConfig;
import com.example.unicap.model.Atividade;
import com.example.unicap.model.Paciente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AtividadesActivity extends AppCompatActivity {

    private Paciente paciente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_detalhes_paciente);


        Bundle extra = getIntent().getExtras();
        if(extra != null) {
            paciente = (Paciente) extra.getSerializable("Paciente");
        }

        TextView nome = findViewById(R.id.textNome);
        TextView idade = findViewById(R.id.textIdade);
        TextView desc = findViewById(R.id.textDescricao);

        nome.setText(String.format("Nome: %s", paciente.getNome()));
        idade.setText(String.format("Data de Nascimento: %s", paciente.getDataNascimento()));
        desc.setText(String.format("Descrição: %s", paciente.getDescricao()));



        Call<List<Atividade>> call = new RetrofitConfig().getAtividadeService().listarAtividade(paciente.getId());

        call.enqueue(new Callback<List<Atividade>>() {
            @Override
            public void onResponse(Call<List<Atividade>> call, Response<List<Atividade>> response) {
                List<Atividade> atividadeList = response.body();
                ListView listView = findViewById(R.id.listViewAtividade);
                listView.setAdapter(new AtividadeAdapter(getApplicationContext(), atividadeList));
                Toast.makeText(getApplicationContext(),"Atividade do Paciente Carregadas",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Atividade>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"FALHOU",Toast.LENGTH_SHORT).show();
            }
        });


        Button button = findViewById (R.id.bt_add_atividade);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CadAtividade.class); //ir para tela de cadastrar atividade
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("Paciente", paciente);
                getApplicationContext().startActivity(i);
            }
        });
    }
}
