package com.example.unicap.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.unicap.fono.R;
import com.example.unicap.model.Exercicio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExercicioAdapter  extends ArrayAdapter<Exercicio> {

    private final Context context;
    private List<Exercicio> exercicioArrayList = new ArrayList<>();
    private String nomeLicao;


    public ExercicioAdapter(@NonNull Context context, List<Exercicio> list, String nomeLicao) {
        super(context, 0, list);
        this.context = context;
        this.exercicioArrayList = list;
        this.nomeLicao = nomeLicao;
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.lista_itens_exercicios, parent, false);

        final Exercicio posicaoPaciente = exercicioArrayList.get(position);

        final ListView listView = listItem.findViewById(R.id.listViewExercicios);


        TextView data = listItem.findViewById(R.id.textData);


        TextView nome = listItem.findViewById(R.id.textNome);

        ProgressBar progressBar = listItem.findViewById(R.id.progressBar);


        data.setText(posicaoPaciente.getDataHoraMarcada().replace("T"," "));
        nome.setText(nomeLicao);



        progressBar.setVisibility(View.INVISIBLE);


        return listItem;
    }

}
