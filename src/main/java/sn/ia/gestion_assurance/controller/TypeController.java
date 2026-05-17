package sn.ia.gestion_assurance.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/type")
public class TypeController {

//GET POST UPDATE DELETE PATCH
    @GetMapping
    public String home(){
        System.out.println("salut");
        return "index";
    }

}
