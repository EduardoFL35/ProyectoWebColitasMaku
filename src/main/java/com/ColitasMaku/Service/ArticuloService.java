package com.ColitasMaku.Service;

import com.ColitasMaku.Domain.Articulo;
import java.util.List;

public interface ArticuloService {
        
    //metodos para hacer CRUD de articulo
    
    public List<Articulo> getArticulos(boolean activos);
    
    public Articulo getArticulo(Articulo articulo);
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
}
