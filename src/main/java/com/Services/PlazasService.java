package com.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.DAO.PlazasDAO;
import com.TO.Plazas;

@Service
public class PlazasService implements IPlazasService {
    
    @Autowired
    private PlazasDAO plazasdao;
    

    @Override
    @Transactional(readOnly = true)
    public List<Plazas> listarPlazas() {
        return (List<Plazas>) plazasdao.findAll();
    }

    @Override
    public void eliminar(int idPlazas) {
        plazasdao.deleteById(idPlazas);
    }

    @Override
    @Transactional
    public Plazas guardar(Plazas plazas) {
        return plazasdao.save(plazas);
        
    }

    @Override
    @Transactional(readOnly = true)
    public Plazas buscarPlazas(int idPlaza) {
        return plazasdao.findById(idPlaza).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Plazas> PlazasLibresxTipo(String tipo) {
        return  (List<Plazas>) plazasdao.plazasLibresxTipo(tipo);
    }

}
