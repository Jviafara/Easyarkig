package com.Ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.Services.PersonasService;
import com.TO.Personas;




@Controller
public class PersonasCtrl {

    @Autowired
    private PersonasService personasService;
    
    //METODOS HTML
    //LISTAR
    @GetMapping("/personas")
    public String inicio(Model model) {  
        iniciar(model);
        return "personas"; 
    } 

    private void iniciar(Model model){
        model.addAttribute("titulo", "Personas");
        if(model.getAttribute("persona")==null){
            Personas persona = new Personas();
            model.addAttribute("persona",persona);
        }
        var personas= personasService.listarPersonas();
        model.addAttribute("personas",personas);
        
    }

    //GUARDAR
    @PostMapping("/personas/guardar")
    public String guardar(Personas persona){
        personasService.guardar(persona);
        return "redirect:/personas";
    }

    //ELIMINAR
    @GetMapping(value ="/personas/eliminar/{idPersonas}")
    public String eliminar(Personas persona){
        personasService.eliminar(persona.getIdPersonas());
        return "redirect:/personas"; 
    }

    //EDITAR
    @GetMapping(value ="/personas/editar/{idPersonas}")
    public String editar(Personas persona, Model model){
        persona = personasService.buscarPersonas(persona.getIdPersonas());
        model.addAttribute("persona", persona);
        iniciar(model);
        return "personas";
    }


    //METODOS POSTOMAN

    @GetMapping("/personas/listar")
    public ResponseEntity<List<Personas>> listarPersonasString() {  
        return new ResponseEntity<>(personasService.listarPersonas(),HttpStatus.OK); 
    }


    @PostMapping("/personas/save")
    public ResponseEntity<Personas> save(@RequestBody Personas persona){
        return new ResponseEntity<>(personasService.guardar(persona), HttpStatus.OK);
    }


}
