package com.ColitasMaku.Dao;

import com.ColitasMaku.Domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao 
        extends JpaRepository<Cliente, Long>{
    
}
