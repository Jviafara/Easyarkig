package com.Services;

import com.TO.Configuraciones;


public interface IConfiguracionesService {
     
    public Configuraciones guardar(Configuraciones configuracion); 
    public Configuraciones buscarConfiguraciones(int IdConfiguraciones);

}
