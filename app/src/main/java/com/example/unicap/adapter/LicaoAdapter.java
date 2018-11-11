package com.example.unicap.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.unicap.fono.ExercicioActivity;
import com.example.unicap.fono.R;
import com.example.unicap.model.Atividade;
import com.example.unicap.model.Licao;
import com.example.unicap.model.Paciente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LicaoAdapter extends ArrayAdapter<Licao> {

    private Context context;
    private List<Licao> listLicao;
    private Paciente paciente;

    public LicaoAdapter(@NonNull Context context, List<Licao> listLicao, Paciente paciente) {
        super(context, 0, listLicao);
        this.context = context;
        this.listLicao = listLicao;
        this.paciente = paciente;
    }


    @NonNull
    @Override
    public View getView(final int position, final View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;

        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.lista_itens_licoes, parent, false);

        final Licao posicaoLicao = listLicao.get(position);
        final CardView cardView = listItem.findViewById(R.id.cardViewLicao);

        TextView textView = listItem.findViewById(R.id.textLicao);
        textView.setText(posicaoLicao.getDescricao());


        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                Intent i = new Intent(context.getApplicationContext(),ExercicioActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("Paciente",paciente);
                i.putExtra("Licao", posicaoLicao);
                context.getApplicationContext().startActivity(i);
            }
        });

        return listItem;
    }
}
