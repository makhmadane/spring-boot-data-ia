package sn.ia.gestion_assurance.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.ia.gestion_assurance.entity.Type;
import sn.ia.gestion_assurance.repository.TypeRepository;

@Controller
@RequestMapping("/type")
public class TypeController {

    private TypeRepository typeRepository;

    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("types", typeRepository.findAll());

        return "type/index";
    }

    @GetMapping("/new")
    public String createForm(Model model){
        model.addAttribute("typeForm", new Type() );
        return "type/add";
    }



    @PostMapping
    public String save(@ModelAttribute Type formType){
        typeRepository.save(formType);
        return "redirect:/type";
    }

}
