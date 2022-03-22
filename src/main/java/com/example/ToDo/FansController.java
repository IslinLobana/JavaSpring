package com.example.ToDo;

import java.util.ArrayList;

import com.example.ToDo.models.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FansController {
    
    ArrayList<Fans> fans;

    public FansController(){
        setFans(new ArrayList<Fans>());

        createDemoData();
    }

    private void createDemoData(){
        getFans().add(new Fans("Christiano", "Orlando", "57", "ManU"));
        getFans().add(new Fans("Lionel", "Mess-Eye", "43", "PSG"));
    }

    @GetMapping("/fans")
    public String fans(@RequestParam(name="activePage", required = false, defaultValue = "fans") String activePage, Model model){
        model.addAttribute("activePage", "fans");
        model.addAttribute("fans", getFans());
        return "index.html";
    }
    
    @RequestMapping("/delfans")
    public String delFans(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "fans") String activePage, Model model){
        getFans().remove(id);
        return "redirect:/fans";
    }

    @RequestMapping("/changefans")
    public String changefans(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "changefans") String activePage, Model model){
        // Fans zur Bearbeitung laden
        model.addAttribute("fans", getFans().get(id));
        model.addAttribute("fansid", id);
        model.addAttribute("activePage", "fansUpdate");
        return "index.html";
    }
    
    @RequestMapping("/updatefans")
    public String updateFans(@RequestParam(name="FansId", required = true, defaultValue = "null") int fansId, @RequestParam(name="FansVorname", required = true, defaultValue = "null") String FansVorname, @RequestParam(name="FansNachname", required = true, defaultValue = "null") String FansNachname, @RequestParam(name="FansGeschlecht", required = true, defaultValue = "null") String FansGeschlecht, @RequestParam(name="FansVerein", required = true, defaultValue = "null") String FansVerein,@RequestParam(name="activePage", required = false, defaultValue = "fans") String activePage, Model model){
        getFans().get(fansId).setVorname(FansVorname);
        getFans().get(fansId).setNachname(FansNachname);
        getFans().get(fansId).setGeschlecht(FansGeschlecht);
        getFans().get(fansId).setVerein(FansVerein);
        return "redirect:/fans";
    }
    
    @RequestMapping("/addfans")
    public String addFans(@RequestParam(name="FansVorname", required = true, defaultValue = "null") String fansVorname,@RequestParam(name="FansNachname", required = true, defaultValue = "null") String fansNachname, @RequestParam(name="FansGeschlecht", required = true, defaultValue = "null") String fansGeschlecht,@RequestParam(name="FansVerein", required = false, defaultValue = "null") String fansVerein, @RequestParam(name="activePage", required = true, defaultValue = "fans") String activePage, Model model){
        getFans().add(new Fans(fansVorname, fansNachname, fansGeschlecht, fansVerein));
        return "redirect:/fans";
    }
    
    
    public void setFans(ArrayList<Fans> fans) {
        this.fans = fans;
    }

    public ArrayList<Fans> getFans() {
        return fans;
    }
    
}
