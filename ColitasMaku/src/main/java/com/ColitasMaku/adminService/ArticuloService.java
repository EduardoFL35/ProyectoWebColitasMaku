/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ColitasMaku.adminService;

import com.ColitasMaku.adminDomain.Articulo;
import java.util.List;

/**
 *
 * @author Jostin Pizarro
 */
public interface ArticuloService {
        
    //metodos para hacer CRUD de articulo
    
    public List<Articulo> getArticulos();
    
    public Articulo getArticulo(Articulo articulo);
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
}
