package com.example.unicap.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unicap.fono.DetalhesExerciciosActivity;
import com.example.unicap.fono.R;
import com.example.unicap.model.Atividade;
import com.example.unicap.model.Exercicio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.graphics.Color.BLACK;

public class AtividadeAdapter extends ArrayAdapter<Atividade> {

    private Context context;
    private List<Atividade> atividadeList;

    public AtividadeAdapter(@NonNull Context context, List<Atividade> listLicao) {
        super(context, 0, listLicao);
        this.context = context;
        this.atividadeList = listLicao;
    }



    @NonNull
    @RequiresApi(api = Build.VERSION_CODES.P)
    @SuppressLint("SimpleDateFormat")
    @Override
    public View getView(final int position, final View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.lista_itens_exercicios, parent, false);

        final Atividade posicaoAtividade = atividadeList.get(position);
        CardView cardView = listItem.findViewById(R.id.cardAtividade);
        TextView nome = listItem.findViewById(R.id.textNome);
        TextView progress = listItem.findViewById(R.id.textProgresso);
        ProgressBar progressBar = listItem.findViewById(R.id.progressBar);
        TextView data = listItem.findViewById(R.id.textData);

        nome.setText(String.format("Lição: %s", posicaoAtividade.getLicao().getNome()));
        data.setText(String.format("Data Marcada: %s", posicaoAtividade.getDataCriacao()));
        progressBar.setMax(posicaoAtividade.getExercicios().size());
        progressBar.setProgress(AtividadesConcluidas(posicaoAtividade.getExercicios()));
        progress.setText(String.format("%s/%s", String.valueOf(AtividadesConcluidas(posicaoAtividade.getExercicios())), String.valueOf(posicaoAtividade.getExercicios().size())));

        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(context.getApplicationContext(),DetalhesExerciciosActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //i.putExtra("Atividade", posicaoAtividade);
                i.putExtra("AtividadeId", posicaoAtividade.getId());
                i.putExtra("Paciente",posicaoAtividade.getPaciente());
                context.getApplicationContext().startActivity(i);

                context.startActivity(i);

            }
        });

        return listItem;
    }



    private int AtividadesConcluidas (List<Exercicio> exercicioList){


    /* "PERFEITO";
    "AGUARDANDO_AVALIACAO";
    "VOCE_PODE_MELHORAR";
    "NAO_REALIZADO";
    */
        int cont = 0;

        for (Exercicio exercicio: exercicioList ) {
            if(exercicio.getStatus().compareToIgnoreCase("PERFEITO") == 0){
                cont ++;

            }

        }

        return cont;

    }

}
