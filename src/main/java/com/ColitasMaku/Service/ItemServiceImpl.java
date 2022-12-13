package com.ColitasMaku.Service;

import com.ColitasMaku.Domain.Item;
import com.ColitasMaku.Service.ItemService;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public List<Item> getItems() {
        return listaItems;
    }

    @Override
    public void save(Item item) {
        boolean existe = false;
        for (Item c : listaItems) {
            //busca si ya existe en el carrito
            if (Objects.equals(c.getIdArticulo(), item.getIdArticulo())) {
                //valida si aun se puede agregar segun la cantidad existente
                if (c.getExistencias() < item.getExistencias()) {
                    //incrementa la cantidad
                    c.setExistencias(c.getExistencias() + 1);
                }
                existe = true;
                break;
            }
        }
        if (!existe) {
            item.setExistencias(1);
            listaItems.add(item);
        }
    }

    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe=false;
        for(Item c:listaItems){
            ++posicion;
            if(Objects.equals(c.getIdArticulo(), item.getIdArticulo())){
                existe=true;
                break;
            }
        }
        if(existe){
            listaItems.remove(posicion);
        }
    }
    
    @Override
    public Item getItem(Item item){
        for(Item c : listaItems){
            if(Objects.equals(c.getIdArticulo(), item.getIdArticulo())){
                return c;
            }
        }
        return null;
    }

    @Override
    public void actualiza(Item item) {
        for(Item i : listaItems){
            if(Objects.equals(i.getIdArticulo(), item.getIdArticulo())){
                i.setExistencias(item.getExistencias());
                break;
            }
        }
    }

    @Override
    public void facturar() {
        for(Item i:listaItems){
            //Proceso de facturación
        }
        listaItems.clear();
    }

}
