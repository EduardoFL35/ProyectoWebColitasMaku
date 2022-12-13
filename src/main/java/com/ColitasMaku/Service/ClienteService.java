/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ColitasMaku.Service;

import com.ColitasMaku.Domain.Cliente;
import java.util.List;

/**
 *
 * @author Jostin Pizarro
 */
public interface ClienteService {
        
    //metodos para hacer CRUD de cliente
    
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Cliente cliente);
    
    public void save(Cliente cliente);
    
    public void delete(Cliente cliente);
}
