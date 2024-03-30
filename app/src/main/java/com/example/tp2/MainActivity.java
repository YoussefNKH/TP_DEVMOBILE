package com.example.tp2;

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

public class MainActivity extends AppCompatActivity {
    private TextView tvAge,tvRepense;
    private EditText etValeur;
    private SeekBar sbAge;
    private RadioButton rbIsFasting,rbIsNotFasting;
    private Button btnConsulter;
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

        //logique de calcule
        Log.i("information","onclick sur le btnconsulter");
        int age;float valeurMesure;
        //verification des champ remplie ou non
        boolean flagAge=false,flagValeurMesure=false;
        if(sbAge.getProgress()!=0){
            flagAge=true;}
        else {Toast.makeText(MainActivity.this,"Veuillez sasir votre age",Toast.LENGTH_SHORT).show();
        }
        if(etValeur.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"le Valeur n'est exsite pas",Toast.LENGTH_LONG).show();}
        else {
            flagValeurMesure=true;
        }

        if(flagAge&&flagValeurMesure){
        age=sbAge.getProgress();
        valeurMesure= Float.valueOf(etValeur.getText().toString());
        if(rbIsFasting.isChecked()){
            if (age >= 13) {
                if (valeurMesure < 5.0) {
                    tvRepense.setText("Niveau de glycémie est bas");
                } else if (valeurMesure >= 5.0 && valeurMesure <= 7.2) {
                    tvRepense.setText("Niveau de glycémie est normal");
                } else {
                    tvRepense.setText("Niveau de glycémie est trop élevé");
                }
            } else if (age >= 6 && age <= 12) {
                if (valeurMesure < 5.0) {
                    tvRepense.setText("Niveau de glycémie est bas");
                } else if (valeurMesure >= 5.0 && valeurMesure <= 10.0) {
                    tvRepense.setText("Niveau de glycémie est normal");
                } else {
                    tvRepense.setText("Niveau de glycémie est trop élevé");
                }
            } else if (age < 6) {
                if (valeurMesure < 5.5) {
                    tvRepense.setText("Niveau de glycémie est bas");
                } else if (valeurMesure >= 5.5 && valeurMesure <= 10.0) {
                    tvRepense.setText("Niveau de glycémie est normal");
                } else {
                    tvRepense.setText("Niveau de glycémie est trop élevé");
                }
            }
        }
        }
    }//fin du methode calculer
}//Fin du class MainActivity
