package com.example.ToDo;

import java.util.ArrayList;

import com.example.ToDo.models.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StadionController {
    
    ArrayList<Stadion> stadion;

    public StadionController(){
        setStadion(new ArrayList<Stadion>());

        createDemoData();
    }

    private void createDemoData(){
        getStadion().add(new Stadion("Christiano", "Orlando", "57"));
        getStadion().add(new Stadion("Lionel", "Mess-Eye", "43"));
    }

    @GetMapping("/stadion")
    public String Stadion(@RequestParam(name="activePage", required = false, defaultValue = "Stadion") String activePage, Model model){
        model.addAttribute("activePage", "Stadion");
        model.addAttribute("stadion", getStadion());
        return "index.html";
    }
    
    @RequestMapping("/delstadion")
    public String delStadion(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "stadion") String activePage, Model model){
        getStadion().remove(id);
        return "redirect:/stadion";
    }

    @RequestMapping("/changestadion")
    public String changeStadion(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "changestadion") String activePage, Model model){
        // Stadion zur Bearbeitung laden
        model.addAttribute("stadion", getStadion().get(id));
        model.addAttribute("stadionid", id);
        model.addAttribute("activePage", "stadionUpdate");
        return "index.html";
    }
    
    @RequestMapping("/updatestadion")
    public String updateStadion(@RequestParam(name="stadionId", required = true, defaultValue = "null") int StadionId, @RequestParam(name="StadionName", required = true, defaultValue = "null") String StadionName, @RequestParam(name="StadionPlaetze", required = true, defaultValue = "null") String StadionPlaetze, @RequestParam(name="StadionHeimverein", required = true, defaultValue = "null") String StadionHeimverein,@RequestParam(name="activePage", required = false, defaultValue = "stadion") String activePage, Model model){
        getStadion().get(StadionId).setName(StadionName);
        getStadion().get(StadionId).setPlaetze(StadionPlaetze);
        getStadion().get(StadionId).setHeimverein(StadionHeimverein);
        return "redirect:/stadion";
    }
    
    @RequestMapping("/addstadion")
    public String addStadion(@RequestParam(name="StadionName", required = true, defaultValue = "null") String StadionName, @RequestParam(name="StadionPlaetze", required = true, defaultValue = "null") String StadionPlaetze,@RequestParam(name="StadionHeimverein", required = false, defaultValue = "null") String StadionHeimverein, @RequestParam(name="activePage", required = true, defaultValue = "Stadion") String activePage, Model model){
        getStadion().add(new Stadion(StadionName, StadionPlaetze, StadionHeimverein));
        return "redirect:/stadion";
    }
    
    
    public void setStadion(ArrayList<Stadion> stadion) {
        this.stadion = stadion;
    }

    public ArrayList<Stadion> getStadion() {
        return stadion;
    }
    
}
