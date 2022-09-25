package com.Ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Services.PersonasService;
import com.Services.UsuariosService;
import com.TO.Usuarios;

@Controller
public class UsuariosCtrl {
    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private PersonasService personasService;

    /* METODOS HTML */
    // LISTAR
    @GetMapping("/usuarios")
    public String inicio(Model model) {
        iniciar(model);
        return "usuarios";
    }

    private void iniciar(Model model) {
        model.addAttribute("titulo", "Usuarios");
        if (model.getAttribute("usuario") == null) {
            Usuarios usuario = new Usuarios();
            model.addAttribute("usuario", usuario);
        }
        var usuarios = usuariosService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        var personas = personasService.listarPersonas();
        model.addAttribute("personas", personas);

    }

    // GUARDAR
    @PostMapping("/usuarios/guardar")
    public String guardar(Usuarios usuario) {
        usuariosService.guardar(usuario);
        return "redirect:/usuarios";
    }

    // ELIMINAR
    @GetMapping(value = "/usuarios/eliminar/{idUsuarios}")
    public String eliminar(Usuarios usuario) {
        usuariosService.eliminar(usuario.getIdUsuarios());
        return "redirect:/usuarios";
    }

    // EDITAR
    @GetMapping(value = "/usuarios/editar/{idUsuarios}")
    public String editar(Usuarios usuario, Model model) {
        usuario = usuariosService.buscarUsuarios(usuario.getIdUsuarios());
        model.addAttribute("usuario", usuario);
        iniciar(model);
        return "usuarios";
    }

    /* Metodos postman */
    // LISTAR
    @GetMapping("/usuarios/listar")
    public ResponseEntity<List<Usuarios>> listarUsuariosString() {
        return new ResponseEntity<>(usuariosService.listarUsuarios(), HttpStatus.OK);
    }

    // GUARDAR
    @PostMapping("/usuarios/save")
    public ResponseEntity<Usuarios> save(@RequestBody Usuarios usuario) {
        // Return JSON
        return new ResponseEntity<>(usuariosService.guardar(usuario), HttpStatus.OK);
    }

    // ELIMINAR
    @RequestMapping(value = "/usuarios/eliminarusr/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarUsr(@PathVariable int id) {
        Usuarios usr = usuariosService.buscarUsuarios(id);
        if (usr != null) {
            usuariosService.eliminar(id);
            return new ResponseEntity<>("Elemento eliminado", HttpStatus.OK);
        }
        return new ResponseEntity<>("Elemento no encontrado", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
