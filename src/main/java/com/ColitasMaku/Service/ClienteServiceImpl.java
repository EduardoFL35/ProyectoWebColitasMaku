package com.ColitasMaku.Service;

import com.ColitasMaku.Domain.Cliente;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ColitasMaku.Dao.ClienteDao;
import com.ColitasMaku.Service.ClienteService;


/**
 *
 * @author Jostin Pizarro
 */
@Service
public class ClienteServiceImpl implements ClienteService {
        
    @Autowired
    private ClienteDao clienteDao;
    

    @Override
    @Transactional
    public List<Cliente> getClientes() {
        return (List<Cliente>)clienteDao.findAll();
    }
    
    @Override
    @Transactional
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
}
