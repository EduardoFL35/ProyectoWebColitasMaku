/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ColitasMaku.Service;

import com.ColitasMaku.Domain.Usuario;
import java.util.List;

/**
 *
 * @author Jostin Pizarro
 */
public interface UsuarioService {
        
    //metodos para hacer CRUD de usuario
    
    public List<Usuario> getUsuarios();
    
    public Usuario getUsuario(Usuario usuario);
    
    public void save(Usuario usuario);
    
    public void delete(Usuario usuario);
}
