package com.Services;

import java.util.List;
import com.TO.Personas;


public interface IPersonasService {
    
    public List<Personas> listarPersonas();
    public void eliminar(int idPersona);
    public Personas guardar(Personas persona); 
    public Personas buscarPersonas(int idPersona);

}
