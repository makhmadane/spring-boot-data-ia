package sn.ia.gestion_assurance.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.ia.gestion_assurance.entity.Type;
import sn.ia.gestion_assurance.repository.TypeRepository;

@Controller
@RequestMapping("/type")
public class TypeController {

    private TypeRepository typeRepository;

    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("types", typeRepository.findAll());

        return "type/index";
    }

    @GetMapping("/new")
    public String createForm(Model model){
        model.addAttribute("typeForm", new Type() );
        return "type/add";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model ){
        Type type = typeRepository.findById(id).get();
        model.addAttribute("type", type);
        return "type/update";

    }


    @PostMapping
    public String save(@ModelAttribute Type formType){
        typeRepository.save(formType);
        return "redirect:/type/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        typeRepository.deleteById(id);
        return "redirect:/type/";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Type type){
        Type typeBd = typeRepository.findById(id).get();
        typeBd.setLibelle(type.getLibelle());
        typeRepository.save(typeBd);
        return "redirect:/type/";
    }



}
