package sn.ia.gestion_assurance.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.ia.gestion_assurance.entity.Assurance;
import sn.ia.gestion_assurance.repository.AssuranceRepository;

import java.util.List;

@Controller
@RequestMapping("/assurance")
public class AssuranceController {

  /*  @Autowired  //IOC
    private AssuranceRepository assuranceRepository;*/


    //repository

    //construct
    private final AssuranceRepository assuranceRepository;

   AssuranceController(AssuranceRepository assuranceRepository){
        this.assuranceRepository = assuranceRepository;
    }

    @GetMapping
    public String getAllAssurance(Model model){
        List<Assurance> assurances =  this.assuranceRepository.findAll();
        model.addAttribute("assurances", assurances);
        return  "assurance/index";
    }

    @GetMapping("/new")
    public String createForm(Model model){
       model.addAttribute("assurance",new Assurance());
       return "assurance/add";
    }

    @PostMapping
    public String save(@ModelAttribute Assurance assurance){
       this.assuranceRepository.save(assurance);
       return "redirect:/assurance";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        assuranceRepository.deleteById(id);
        return "redirect:/assurance";
    }


}
