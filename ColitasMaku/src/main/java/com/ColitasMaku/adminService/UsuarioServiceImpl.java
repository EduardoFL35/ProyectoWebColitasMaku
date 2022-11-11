/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ColitasMaku.adminService;

import com.ColitasMaku.adminDao.UsuarioDao;
import com.ColitasMaku.adminDomain.Usuario;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Jostin Pizarro
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
        
    @Autowired
    private UsuarioDao usuarioDao;
    

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        return (List<Usuario>)usuarioDao.findAll();
    }
    
    @Override
    @Transactional
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
}
