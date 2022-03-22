package com.example.ToDo;

import java.util.ArrayList;

import com.example.ToDo.models.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TrainerController {
    
    ArrayList<Trainer> trainer;

    public TrainerController(){
        setTrainer(new ArrayList<Trainer>());

        createDemoData();
    }

    private void createDemoData(){
        getTrainer().add(new Trainer("Christiano", "Orlando", "57", "60"));
        getTrainer().add(new Trainer("Lionel", "Mess-Eye", "43", "50"));
    }

    @GetMapping("/trainer")
    public String Trainer(@RequestParam(name="activePage", required = false, defaultValue = "trainer") String activePage, Model model){
        model.addAttribute("activePage", "trainer");
        model.addAttribute("trainer", getTrainer());
        return "index.html";
    }
    
    @RequestMapping("/deltrainer")
    public String delTrainer(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "trainer") String activePage, Model model){
        getTrainer().remove(id);
        return "redirect:/trainer";
    }

    @RequestMapping("/changetrainer")
    public String changeTrainer(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "changetrainer") String activePage, Model model){
        // Trainer zur Bearbeitung laden
        model.addAttribute("trainer", getTrainer().get(id));
        model.addAttribute("trainerid", id);
        model.addAttribute("activePage", "trainerUpdate");
        return "index.html";
    }
    
    @RequestMapping("/updatetrainer")
    public String updateTrainer(@RequestParam(name="TrainerId", required = true, defaultValue = "null") int TrainerId, @RequestParam(name="TrainerVorname", required = true, defaultValue = "null") String TrainerVorname,  @RequestParam(name="TrainerNachname", required = true, defaultValue = "null") String TrainerNachname, @RequestParam(name="TrainerVerein", required = true, defaultValue = "null") String TrainerVerein, @RequestParam(name="TrainerAlter", required = true, defaultValue = "null") String TrainerAlter,@RequestParam(name="activePage", required = false, defaultValue = "Trainer") String activePage, Model model){
        getTrainer().get(TrainerId).setVorname(TrainerVorname);
        getTrainer().get(TrainerId).setNachname(TrainerNachname);
        getTrainer().get(TrainerId).setVerein(TrainerVerein);
        getTrainer().get(TrainerId).setAlter(TrainerAlter);
        return "redirect:/trainer";
    }
    
    @RequestMapping("/addtrainer")
    public String addTrainer(@RequestParam(name="TrainerVorname", required = true, defaultValue = "null") String TrainerVorname, @RequestParam(name="TrainerNachname", required = true, defaultValue = "null") String TrainerNachname, @RequestParam(name="TrainerVerein", required = true, defaultValue = "null") String TrainerVerein,@RequestParam(name="TrainerAlter", required = false, defaultValue = "null") String TrainerAlter, @RequestParam(name="activePage", required = true, defaultValue = "Trainer") String activePage, Model model){
        getTrainer().add(new Trainer(TrainerVorname, TrainerNachname, TrainerVerein, TrainerAlter));
        return "redirect:/trainer";
    }
    
    
    public void setTrainer(ArrayList<Trainer> trainer) {
        this.trainer = trainer;
    }

    public ArrayList<Trainer> getTrainer() {
        return trainer;
    }
    
}
