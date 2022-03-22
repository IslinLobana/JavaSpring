package com.example.ToDo.models;

public class Spieler extends Person{

    String alter;
    String verein;

    public Spieler(String vorname, String nachname, String alter, String verein){
        super(vorname, nachname);
        setAlter(alter);
        setVerein(verein);
    }
    public void setAlter(String alter) {
        this.alter = alter;
    }


     public void setVerein(String verein) {
         this.verein = verein;
     }
     public String getAlter() {
         return alter;
     }
     public String getVerein() {
         return verein;
     }

    
}
