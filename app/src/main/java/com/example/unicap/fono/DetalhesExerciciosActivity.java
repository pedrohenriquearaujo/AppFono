package com.example.unicap.fono;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.unicap.adapter.AudioAdapter;
import com.example.unicap.model.Atividade;

public class DetalhesExerciciosActivity extends AppCompatActivity {


    private Bundle extra;

    private Atividade atividade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_detalhes_atividade);


        extra = getIntent().getExtras();
        if(extra != null) {
            atividade = (Atividade) extra.getSerializable("Atividade");
        }


        TextView nomeLicao = findViewById(R.id.textView3);
        TextView descricao = findViewById(R.id.textView);

        nomeLicao.setText(atividade.getLicao().getNome());

        descricao.setText(atividade.getLicao().getDescricao());

        ListView listView = findViewById(R.id.listGravacao);






        listView.setAdapter(new AudioAdapter(getApplicationContext(), atividade.getExercicios() ,atividade));

    }

}