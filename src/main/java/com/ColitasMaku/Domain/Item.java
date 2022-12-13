
package com.ColitasMaku.Domain;

import lombok.Data;

@Data
public class Item extends Articulo{
    private int existencias;//guarda cantidad de articulos

    public Item() {
    }

    public Item(Articulo articulo){
        super.setIdArticulo(articulo.getIdArticulo());
        super.setNombre(articulo.getNombre());
        super.setDescripcion(articulo.getDescripcion());
        super.setPrecio(articulo.getPrecio());
        super.setCantidad(articulo.getCantidad());
        super.setActivo(articulo.isActivo());
        super.setRutaImagen(articulo.getRutaImagen());
        this.existencias=0;
    }
    
    
}
