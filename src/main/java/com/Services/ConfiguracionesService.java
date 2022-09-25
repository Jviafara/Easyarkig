package com.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.DAO.ConfiguracionesDAO;
import com.TO.Configuraciones;

@Service
public class ConfiguracionesService implements IConfiguracionesService {
  
    @Autowired
    private ConfiguracionesDAO configuracionesdao;

    @Override
    @Transactional
    public Configuraciones guardar(Configuraciones configuracion) {
        return configuracionesdao.save(configuracion);
    }

    @Override
    @Transactional(readOnly = true)
    public Configuraciones buscarConfiguraciones(int idConfiguraciones) {
        return configuracionesdao.findById(idConfiguraciones).orElse(null);
    }


}
