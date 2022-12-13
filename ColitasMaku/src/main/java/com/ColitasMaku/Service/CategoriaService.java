/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ColitasMaku.Service;

import com.ColitasMaku.Domain.Categoria;
import java.util.List;

/**
 *
 * @author Jostin Pizarro
 */
public interface CategoriaService {
        
    //metodos para hacer CRUD de categoria
    
    public List<Categoria> getCategorias(boolean activos);
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);
}
