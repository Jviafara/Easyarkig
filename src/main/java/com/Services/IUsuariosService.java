package com.Services;

import java.util.List;
import com.TO.Usuarios;

public interface IUsuariosService {

    public List<Usuarios> listarUsuarios();
    public void eliminarUsr(Usuarios usuario);
    public void eliminar(int idUsuario);
    public Usuarios guardar(Usuarios usuario); 
    public Usuarios buscarUsuarios(int idUsuarios);
    
}
