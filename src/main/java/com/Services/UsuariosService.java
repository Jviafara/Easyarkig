package com.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.DAO.UsuariosDAO;
import com.TO.Usuarios;

@Service
public class UsuariosService implements IUsuariosService{

    @Autowired
    private UsuariosDAO usuariosdao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> listarUsuarios() {
        return (List<Usuarios>) usuariosdao.findAll();
    }

    @Override
    @Transactional
    public void eliminarUsr(Usuarios usuario){
        usuariosdao.delete(usuario);
    }

    @Override
    public void eliminar(int idUsuario){
        usuariosdao.deleteById(idUsuario);
    }

    @Override
    @Transactional
    public Usuarios guardar(Usuarios usuario) {
        return usuariosdao.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios buscarUsuarios(int idUsuarios) {
        return usuariosdao.findById(idUsuarios).orElse(null);
    }
    
}
