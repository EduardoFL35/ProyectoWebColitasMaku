/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ColitasMaku.Service;

import com.ColitasMaku.Domain.Pedido;
import java.util.List;

/**
 *
 * @author Jostin Pizarro
 */
public interface PedidoService {
        
    //metodos para hacer CRUD de cliente
    
    public List<Pedido> getPedidos();
    
    public Pedido getPedido(Pedido cliente);
    
    public void save(Pedido cliente);
    
    public void delete(Pedido cliente);
}
