/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ColitasMaku.Dao;

import com.ColitasMaku.Domain.Articulo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jostin Pizarro
 */
public interface ArticuloDao extends JpaRepository<Articulo, Long>{
 
    public List<Articulo> findByIdCategoria(Long categoria);
}
