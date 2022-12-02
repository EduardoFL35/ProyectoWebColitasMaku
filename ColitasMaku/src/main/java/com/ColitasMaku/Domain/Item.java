
package com.ColitasMaku.Domain;

import lombok.Data;

@Data
public class Item extends Articulo{
    private int cantidad;//guarda cantidad de articulos

    public Item() {
    }

    public Item(Articulo articulo){
        super.setIdArticulo(articulo.getIdArticulo());
        super.setIdCategoria(articulo.getIdCategoria());
        super.setDescripcion(articulo.getDescripcion());
        super.setPrecio(articulo.getPrecio());
        super.setCantidad(articulo.getCantidad());
        super.setActivo(articulo.isActivo());
        super.setUrl(articulo.getUrl());
        this.cantidad=0;
    }
    
    
}
