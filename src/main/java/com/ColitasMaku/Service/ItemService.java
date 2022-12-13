package com.ColitasMaku.Service;

import com.ColitasMaku.Domain.Item;
import java.util.ArrayList;
import java.util.List;

public interface ItemService {
        
    //metodos para hacer CRUD de item
    //en lugar de usar BD se usa array para regidtro temporal
    public List<Item> listaItems= new ArrayList<>();
    
    public List<Item> getItems();
    
    public void save(Item item);
    
    public void delete(Item item);
    
    public Item getItem(Item item);
    
    public void actualiza(Item item);
    
    public void facturar();
}
