package com.example.draft.farmer.demo.controller;

import com.example.draft.farmer.demo.entity.Farmer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("farmer")
public class FarmerController {

    private List<Farmer> farmers = new ArrayList<Farmer>();


    public void setupFarmers(){
        Farmer fm1 = new Farmer("Panos","Foteinopoulos", "Pasta Elias", "Peloponnisos", "OilShip OE");
        Farmer fm2 = new Farmer("Panos","Foteinolakis", "Ladi", "Peloponnisos", "OilShip OE");
            farmers.add(fm1);
            farmers.add(fm2);
    }

    public String showFarmersAttributes(Model model){
        model.addAttribute("frms",farmers);
        return "farmers";

    }
    @GetMapping("{id}")
    public String showFarmer(@PathVariable  Integer id, Model model){
        Farmer fmra = farmers.get(id);
        List <Farmer>  fmrr = new ArrayList<Farmer>();
        fmrr.add(fmra);
        model.addAttribute("farmers",fmrr);
        return "farmers";
    }

    @GetMapping("/new")
    public String addFarmer(Model model){
        Farmer farmer = new Farmer();
        model.addAttribute("farmer",farmer);

        return "add_farmer";
    }

    @PostMapping("/new")
    public String saveFarmer(@ModelAttribute("farmer") Farmer farmer, Model model){
        System.out.println(farmer);
        System.out.println(farmers);
        farmers.add(farmer);
        model.addAttribute("farmers",farmers);
        return "farmers";
    }

    @GetMapping("delete/{id}")
    public String deleteFarmer(@PathVariable  Integer id, Model model){
        Farmer frm = farmers.get(id);
        farmers.remove(frm);
        model.addAttribute("farmers",farmers);
        return "farmers";
    }


}
