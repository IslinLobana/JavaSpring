package com.example.ToDo.models;

public class Trikot extends Person{

    String rueckennummer;
    String preis;
    

    public Trikot(String vorname, String nachname, String rueckennumer, String preis){
        super(vorname, nachname);
        setRueckennummer(rueckennummer);
        setPreis(preis);
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }
    public void setRueckennummer(String rueckennummer) {
        this.rueckennummer = rueckennummer;
    }
    public String getPreis() {
        return preis;
    }
    public String getRueckennummer() {
        return rueckennummer;
    }
}
