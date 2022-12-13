package com.ColitasMaku.Dao;


import com.ColitasMaku.Domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao
        extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
