package com.example.tp2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tp2.R;
import com.example.tp2.controller.Controller;

public class MainActivity extends AppCompatActivity {
    private TextView tvAge,tvRepense;
    private EditText etValeur;
    private SeekBar sbAge;
    private RadioButton rbIsFasting,rbIsNotFasting;
    private Button btnConsulter;

    private Controller controller ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Mettre à jour l'âge affiché lors du défilement de la barre
                Log.i("information","on progressChange"+progress);
                tvAge.setText("Votre age : "+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            //vide
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            //vide
            }
        });
    btnConsulter.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            calculer();
        }
    });

    }//fin OnCreate

    // Méthode pour initialiser les vues
    private void init(){
        controller=Controller.getInstance();
        tvAge=findViewById(R.id.tvAge);
        tvRepense=findViewById(R.id.tvReponse);
        etValeur=findViewById(R.id.etValeur);
        sbAge=findViewById(R.id.sbAge);
        rbIsFasting=findViewById(R.id.rbtOui);
        rbIsNotFasting=findViewById(R.id.rbtNon);
        btnConsulter=findViewById(R.id.btnConsulter);
    }
    // Méthode pour effectuer le calcul
    private void calculer() {
        int age = Integer.parseInt(tvAge.getText().toString());
        float valeur = Float.parseFloat(etValeur.getText().toString());

        controller.createPatient(age,valeur,rbIsFasting.isChecked());
        tvRepense.setText(controller.getReponse());

    }//fin du methode calculer
}//Fin du class MainActivity
