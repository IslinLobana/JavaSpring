package com.example.ToDo.models;

public class Trainer extends Person{

    String verein;
    String alter;




    public Trainer(String vorname, String nachname, String verein, String alter){
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
