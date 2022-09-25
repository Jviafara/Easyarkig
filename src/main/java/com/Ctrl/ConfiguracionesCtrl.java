package com.Ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Services.ConfiguracionesService;
import com.TO.Configuraciones;




@Controller
public class ConfiguracionesCtrl {

    @Autowired
    private ConfiguracionesService configuracionesService;

    //INICIO
    @GetMapping("/configuraciones")
    private String inicio(Model model){
        model.addAttribute("titulo", "Configuraciones");
        Configuraciones configuracion = configuracionesService.buscarConfiguraciones(1);
        model.addAttribute("configuracion", configuracion);
        return "configuraciones";
    }

    //GUARDAR
    @PostMapping("/configuraciones/guardar")
    public String guardar(Configuraciones configuracion){
        configuracionesService.guardar(configuracion);
        return "redirect:/configuraciones";
    }



}

