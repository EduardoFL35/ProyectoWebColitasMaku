/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ColitasMaku.adminDao;


import com.ColitasMaku.adminDomain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jostin Pizarro
 */
public interface CategoriaDao extends JpaRepository<Categoria, Long>{
    
}
