package com.example.unicap.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unicap.fono.R;
import com.example.unicap.retrofit.Config.RetrofitConfig;
import com.example.unicap.model.Atividade;
import com.example.unicap.model.Exercicio;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AudioAdapter  extends ArrayAdapter<Exercicio> {

    private Context context;
    private List<Exercicio> exercicioList;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    boolean audio;
    private Atividade atividade;

    private String path = Environment.getExternalStorageDirectory() + File.separator;

    public AudioAdapter(Context context, List<Exercicio> list, Atividade a) {
        super(context, 0, list);
        this.context = context;
        this.exercicioList = list;
        this.atividade = a;
    }

    @NonNull
    @Override
    public View getView(final int position, final View convertView, @NonNull ViewGroup parent) {


        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.lista_itens_detalhes_exercicios,parent,false);
        final Exercicio exercicio = exercicioList.get(position);

        final TextView text_data = listItem.findViewById(R.id.text_data);


        final TextView text_status = listItem.findViewById(R.id.text_status);




        text_data.setText(exercicio.getDataHoraMarcada().replace("T","\n"));

        text_status.setText(exercicio.getStatus().replace("_", " "));

        final Button bt_reproduzir = listItem.findViewById(R.id.bt_reproduzir);
        final Button bt_aprovado = listItem.findViewById(R.id.bt_aprovado);
        final Button bt_melhorar = listItem.findViewById(R.id.bt_melhorar);

        audio = false;
        bt_reproduzir.setEnabled(true);
        bt_aprovado.setEnabled(false);
        bt_melhorar.setEnabled(false);

        if (exercicio.getStatus().compareToIgnoreCase("NAO_REALIZADO") == 0){
            bt_reproduzir.setEnabled(false);
        }

        bt_reproduzir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bt_melhorar.setEnabled(true);
                bt_aprovado.setEnabled(true);

                if(isAudio()) {
                    playMp3(exercicioList.get(position).getAudio());
                }else{
                    mediaPlayer.stop();
                }


            }
        });

        bt_aprovado.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Status: Excelente Definido", Toast.LENGTH_LONG).show();

                atividade.getExercicios().get(position).setStatus("PERFEITO");



                Call<Exercicio> call = new RetrofitConfig().getExerciciosService().atualizarExercicio(atividade.getExercicios().get(position));

                call.enqueue(new Callback<Exercicio>() {
                    @Override
                    public void onResponse(@NonNull Call<Exercicio> call, @NonNull Response<Exercicio> response) {

                        Exercicio atividadeList = response.body();
                        Toast.makeText(context,"Status Atualizado",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(@NonNull Call<Exercicio> call, @NonNull Throwable t) {

                        Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();

                    }

                });




                bt_reproduzir.setEnabled(true);
                bt_aprovado.setEnabled(false);
                bt_melhorar.setEnabled(true);


            }
        });

        bt_melhorar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(context, "Status: Voce pode Melhor Definido", Toast.LENGTH_LONG).show();

                atividade.getExercicios().get(position).setStatus("VOCE_PODE_MELHORAR");


                Call<Exercicio> call = new RetrofitConfig().getExerciciosService().atualizarExercicio(atividade.getExercicios().get(position));

                call.enqueue(new Callback<Exercicio>() {
                    @Override
                    public void onResponse(Call<Exercicio> call, Response<Exercicio> response) {

                        Toast.makeText(context,"Status Atualizado",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<Exercicio> call, Throwable t) {

                        Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();

                    }

                });



                bt_aprovado.setEnabled(true);
                bt_melhorar.setEnabled(false);

            }
        });

        return listItem;
    }


    public boolean isAudio (){

        return this.audio = !this.audio;
    }





    private void playMp3(byte[] mp3SoundByteArray) {

        try {

            File tempMp3 = File.createTempFile("audio", "mp3", this.getContext().getCacheDir());
            tempMp3.deleteOnExit();
            FileOutputStream fos = new FileOutputStream(tempMp3);
            fos.write(mp3SoundByteArray);
            fos.close();

            mediaPlayer.reset();

            FileInputStream fis = new FileInputStream(tempMp3);
            mediaPlayer.setDataSource(fis.getFD());

            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException ex) {
            String s = ex.toString();
            ex.printStackTrace();
        }
    }





}
