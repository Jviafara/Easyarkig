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

import com.Services.PlazasService;
import com.TO.Plazas;

@Controller
public class PlazasCtrl {

    @Autowired
    private PlazasService plazasService;
    
            /* METODOS HTML */
    //LISTAR
    @GetMapping("/plazas")
    public String inicio(Model model) {  
        iniciar(model);
        return "plazas"; 
    } 

    private void iniciar(Model model){
        model.addAttribute("titulo", "Plazas");
        if(model.getAttribute("plaza")==null){
            Plazas plaza = new Plazas();
            model.addAttribute("plaza",plaza);
        }
        var plazas= plazasService.listarPlazas();
        model.addAttribute("plazas",plazas);
    }

    //GUARDAR
    @PostMapping("/plazas/guardar")
    public String guardar(Plazas plaza){
        plazasService.guardar(plaza);
        return "redirect:/plazas";
    }

    //ELIMINAR
    @GetMapping(value ="/plazas/eliminar/{idPlazas}")
    public String eliminar(Plazas plaza){
        plazasService.eliminar(plaza.getIdPlazas()); 
        return "redirect:/plazas";
    }

    //EDITAR
    @GetMapping(value ="/plazas/editar/{idPlazas}")
    public String editar(Plazas plaza, Model model){
        plaza =  plazasService.buscarPlazas(plaza.getIdPlazas());
        model.addAttribute("plaza",plaza);
        iniciar(model);
        return "plazas";
    }


            /*  METODOS POSTMAM */

    //LISTAR
    @GetMapping("/plazas/listar")
    public ResponseEntity<List<Plazas>> listarPlazasString() {  
        return new ResponseEntity<>(plazasService.listarPlazas(),HttpStatus.OK); 
    }

    //GUARDAR
    @PostMapping("/plazas/save")
    public ResponseEntity<Plazas> save(@RequestBody Plazas plaza){
        return new ResponseEntity<>(plazasService.guardar(plaza), HttpStatus.OK);
    }

}
