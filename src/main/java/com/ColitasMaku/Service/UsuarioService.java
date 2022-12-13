package com.ColitasMaku.Service;


import com.ColitasMaku.Dao.UsuarioDao;
import com.ColitasMaku.Domain.Rol;
import com.ColitasMaku.Domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService implements UserDetailsService{

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {
        //Buscar el usuario en la tabla de usuarios
        Usuario usuario=usuarioDao.findByUsername(username);
        
        //Se verifica que el usuario existe... sino se lanza una exception
        if(usuario==null){
            throw new UsernameNotFoundException(username);
        }
        
        //Se cargan los roles del usuario
        var roles = new ArrayList<GrantedAuthority>();
        
        //Por medio de la asociación se recuperan los roles de la tabla de roles
        for(Rol rol:usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        //Se crea un nuevo usuario
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }
}
