package com.example.tp2.controller;

import com.example.tp2.model.Patient;

public class Controller {
    private static Patient patient;
    private static Controller instance=null;
    private Controller(){
        super();
    }
    public void createPatient(int age,float valeurMesuree,boolean isFasting){
        patient=new Patient(age,valeurMesuree,isFasting);
    }
    public String getReponse(){
        return patient.getResult();
    }
    public static final Controller getInstance(){
        if(null==instance){
            instance=new Controller();
        }
        return instance;
    }
}
