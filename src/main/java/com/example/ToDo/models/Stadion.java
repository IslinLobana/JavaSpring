package com.example.ToDo.models;

public class Stadion {
    String name;
    String plaetze;
    String heimverein;


    public Stadion(String name, String plaetze, String heimverein){
        setName(name);
        setPlaetze(plaetze);
        setHeimverein(heimverein);
    }

    public void setHeimverein(String heimverein) {
        this.heimverein = heimverein;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPlaetze(String plaetze) {
        this.plaetze = plaetze;
    }
    public String getHeimverein() {
        return heimverein;
    }
    public String getName() {
        return name;
    }public String getPlaetze() {
        return plaetze;
    }
    
}
