package sn.ia.gestion_assurance.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assurance")
public class AssuranceController {

    @GetMapping
    public String getAllAssurance(){
        System.out.println("Ici c Assurance");
         return  "assurance/index";
    }
}
