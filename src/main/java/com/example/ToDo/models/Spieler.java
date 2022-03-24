package com.example.ToDo.models;

public class Spieler extends Person{

    int alter;
    String verein;

    public Spieler(String vorname, String nachname, int alter, String verein){
        super(vorname, nachname);
        setAlter(alter);
        setVerein(verein);
    }
    public void setAlter(int alter) {
        this.alter = alter;
    }


     public void setVerein(String verein) {
         this.verein = verein;
     }
     public int getAlter() {
         return alter;
     }
     public String getVerein() {
         return verein;
     }

    
}
