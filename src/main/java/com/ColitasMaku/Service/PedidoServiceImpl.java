package com.ColitasMaku.Service;

import com.ColitasMaku.Domain.Pedido;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ColitasMaku.Dao.PedidoDao;
import com.ColitasMaku.Service.PedidoService;


/**
 *
 * @author Jostin Pizarro
 */
@Service
public class PedidoServiceImpl implements PedidoService {
        
    @Autowired
    private PedidoDao pedidoDao;
    

    @Override
    @Transactional
    public List<Pedido> getPedidos() {
        return (List<Pedido>)pedidoDao.findAll();
    }
    
    @Override
    @Transactional
    public Pedido getPedido(Pedido pedido) {
        return pedidoDao.findById(pedido.getIdPedido()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Pedido pedido) {
        pedidoDao.save(pedido);
    }

    @Override
    @Transactional
    public void delete(Pedido pedido) {
        pedidoDao.delete(pedido);
    }
}
