package com.example.ToDo;

import java.util.ArrayList;

import com.example.ToDo.models.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SpielerController {
    
    ArrayList<Spieler> spieler;
    ArrayList<Vereine> vereine;
    

    public SpielerController(){
        setSpieler(new ArrayList<Spieler>());

        createDemoData();
    }

    private void createDemoData(){
        getSpieler().add(new Spieler("Christiano", "Orlando", 57, "ManU"));
        getSpieler().add(new Spieler("Lionel", "Mess-Eye", 43, "PSG"));
    }

    @GetMapping("/spieler")
    public String spieler(@RequestParam(name="activePage", required = false, defaultValue = "spieler") String activePage, Model model){
        model.addAttribute("activePage", "spieler");
        model.addAttribute("spieler", getSpieler());
        return "index.html";
    }
    
    @RequestMapping("/delspieler")
    public String delSpieler(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "spieler") String activePage, Model model){
        getSpieler().remove(id);
        return "redirect:/spieler";
    }

    @RequestMapping("/changespieler")
    public String changespieler(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "changespieler") String activePage, Model model){
        // Spieler zur Bearbeitung laden
        model.addAttribute("spieler", getSpieler().get(id));
        model.addAttribute("spielerid", id);
        model.addAttribute("activePage", "spielerUpdate");
        return "index.html";
    }
    
    @RequestMapping("/updatespieler")
    public String updateSpieler(@RequestParam(name="SpielerId", required = true, defaultValue = "null") int spielerId, @RequestParam(name="SpielerVorname", required = true, defaultValue = "null") String SpielerVorname, @RequestParam(name="SpielerNachname", required = true, defaultValue = "null") String SpielerNachname, @RequestParam(name="SpielerAlter", required = true, defaultValue = "0") int SpielerAlter, @RequestParam(name="SpielerVerein", required = true, defaultValue = "null") String SpielerVerein,@RequestParam(name="activePage", required = false, defaultValue = "spieler") String activePage, Model model){
        getSpieler().get(spielerId).setVorname(SpielerVorname);
        getSpieler().get(spielerId).setNachname(SpielerNachname);
        getSpieler().get(spielerId).setAlter(SpielerAlter);
        getSpieler().get(spielerId).setVerein(SpielerVerein);
        return "redirect:/spieler";
    }
    
    @RequestMapping("/addspieler")
    public String addSpieler(@RequestParam(name="SpielerVorname", required = true, defaultValue = "null") String spielerVorname,@RequestParam(name="SpielerNachname", required = true, defaultValue = "null") String spielerNachname, @RequestParam(name="SpielerAlter", required = true, defaultValue = "null") int spielerAlter,@RequestParam(name="SpielerVerein", required = false, defaultValue = "null") String spielerVerein, @RequestParam(name="activePage", required = true, defaultValue = "spieler") String activePage, Model model){
        getSpieler().add(new Spieler(spielerVorname, spielerNachname, spielerAlter, spielerVerein));
        return "redirect:/spieler";
    }
    
    
    public void setSpieler(ArrayList<Spieler> spieler) {
        this.spieler = spieler;
    }

    public ArrayList<Spieler> getSpieler() {
        return spieler;
    }

    
    
}
