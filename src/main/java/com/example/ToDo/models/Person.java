package com.example.ToDo.models;

public abstract class Person {

    String vorname;
    String nachname;




    public Person(String vorname, String nachname){
        setVorname(vorname);
        setNachname(nachname);

    }
            
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public String getNachname() {
        return nachname;
    }
    public String getVorname() {
        return vorname;
    }
    


    
}

