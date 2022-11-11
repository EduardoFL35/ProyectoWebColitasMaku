/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ColitasMaku.adminDao;

import com.ColitasMaku.adminDomain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jostin Pizarro
 */
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    
}
