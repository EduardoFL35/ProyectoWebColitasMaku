package com.ColitasMaku.Dao;

import com.ColitasMaku.Domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDao 
        extends JpaRepository<Pedido, Long>{
    
}
