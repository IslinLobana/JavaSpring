package com.example.ToDo.models;

public class Fans extends Person{

    String verein;
    String geschlecht;



    public Fans(String vorname, String nachname, String verein, String geschlecht){
        super(vorname, nachname);
        setVerein(verein);
        setGeschlecht(geschlecht);
    }


    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }
    public void setVerein(String verein) {
        this.verein = verein;
    }
    public String getGeschlecht() {
        return geschlecht;
    }
    public String getVerein() {
        return verein;
    }
    



    
    
}
