package com.example.ToDo;

import java.util.ArrayList;

import com.example.ToDo.models.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TrikotController {
    
    ArrayList<Trikot> trikot;

    public TrikotController(){
        setTrikot(new ArrayList<Trikot>());

        createDemoData();
    }

    private void createDemoData(){
        getTrikot().add(new Trikot("Christiano", "Orlando", "57", "60"));
        getTrikot().add(new Trikot("Lionel", "Mess-Eye", "43", "50"));
    }

    @GetMapping("/trikot")
    public String Trikot(@RequestParam(name="activePage", required = false, defaultValue = "trikot") String activePage, Model model){
        model.addAttribute("activePage", "trikot");
        model.addAttribute("trikot", getTrikot());
        return "index.html";
    }
    
    @RequestMapping("/deltrikot")
    public String delTrikot(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "trikot") String activePage, Model model){
        getTrikot().remove(id);
        return "redirect:/trikot";
    }

    @RequestMapping("/changetrikot")
    public String changeTrikot(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "changetrikot") String activePage, Model model){
        // Trikot zur Bearbeitung laden
        model.addAttribute("trikot", getTrikot().get(id));
        model.addAttribute("trikotid", id);
        model.addAttribute("activePage", "trikotUpdate");
        return "index.html";
    }
    
    @RequestMapping("/updatetrikot")
    public String updateTrikot(@RequestParam(name="trikotId", required = true, defaultValue = "null") int TrikotId, @RequestParam(name="TrikotVorname", required = true, defaultValue = "null") String TrikotVorname,  @RequestParam(name="TrikotNachname", required = true, defaultValue = "null") String TrikotNachname, @RequestParam(name="TrikotRueckennummer", required = true, defaultValue = "null") String TrikotRueckennummer, @RequestParam(name="TrikotPreis", required = true, defaultValue = "null") String TrikotPreis,@RequestParam(name="activePage", required = false, defaultValue = "trikot") String activePage, Model model){
        getTrikot().get(TrikotId).setVorname(TrikotVorname);
        getTrikot().get(TrikotId).setNachname(TrikotNachname);
        getTrikot().get(TrikotId).setRueckennummer(TrikotRueckennummer);
        getTrikot().get(TrikotId).setPreis(TrikotPreis);
        return "redirect:/trikot";
    }
    
    @RequestMapping("/addtrikot")
    public String addTrikot(@RequestParam(name="TrikotVorname", required = true, defaultValue = "null") String TrikotVorname, @RequestParam(name="TrikotNachname", required = true, defaultValue = "null") String TrikotNachname, @RequestParam(name="TrikotRueckennummer", required = true, defaultValue = "null") String TrikotRueckennummer,@RequestParam(name="TrikotPreis", required = false, defaultValue = "null") String TrikotPreis, @RequestParam(name="activePage", required = true, defaultValue = "trikot") String activePage, Model model){
        getTrikot().add(new Trikot(TrikotVorname, TrikotNachname, TrikotRueckennummer, TrikotPreis));
        return "redirect:/trikot";
    }
    
    
    public void setTrikot(ArrayList<Trikot> trikot) {
        this.trikot = trikot;
    }

    public ArrayList<Trikot> getTrikot() {
        return trikot;
    }
    
}
