package com.Services;

import java.util.List;
import com.TO.Plazas;


public interface IPlazasService {
    
    public List<Plazas> listarPlazas();
    public List<Plazas> PlazasLibresxTipo(String tipo);
    public void eliminar(int idPlazas);
    public Plazas guardar(Plazas plazas); 
    public Plazas buscarPlazas(int idPlazas);

}
