package sn.ia.gestion_assurance.controller.api;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.ia.gestion_assurance.entity.Type;
import sn.ia.gestion_assurance.repository.TypeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/type")
public class TypeRestController {

    private TypeRepository typeRepository;

    public TypeRestController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @GetMapping
    public List<Type> index(){
       return typeRepository.findAll();
    }


    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model ){
        Type type = typeRepository.findById(id).get();
        model.addAttribute("type", type);
        return "type/update";

    }


    @PostMapping
    public Type save(@RequestBody Type formType){
       return  typeRepository.save(formType);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        typeRepository.deleteById(id);
        return "type supprime avec succes";
    }

    @PutMapping("/{id}")
    public Type update(@PathVariable Long id, @RequestBody Type type){
        Type typeBd = typeRepository.findById(id).get();
        typeBd.setLibelle(type.getLibelle());
        return typeRepository.save(typeBd);
    }



}
