package com.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.DAO.PersonasDAO;
import com.TO.Personas;

@Service
public class PersonasService implements IPersonasService {
    
    @Autowired
    private PersonasDAO personasdao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Personas> listarPersonas() {
        return (List<Personas>) personasdao.findAll();
    }

    @Override
    public void eliminar(int idPersonas) {
        personasdao.deleteById(idPersonas);
    }

    @Override
    @Transactional
    public Personas guardar(Personas persona) {
        return personasdao.save(persona);
        
    }

    @Override
    @Transactional(readOnly = true)
    public Personas buscarPersonas(int idPersona) {
        return personasdao.findById(idPersona).orElse(null);
    }

}
