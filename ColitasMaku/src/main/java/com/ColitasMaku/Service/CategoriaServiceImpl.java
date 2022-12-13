package com.ColitasMaku.Service;

import com.ColitasMaku.Service.CategoriaService;
import com.ColitasMaku.Dao.CategoriaDao;
import com.ColitasMaku.Domain.Categoria;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoriaServiceImpl implements CategoriaService {
        
    @Autowired
    private CategoriaDao categoriaDao;
    

    @Override
    @Transactional
    public List<Categoria> getCategorias(boolean activos) {
        var lista=(List<Categoria>) categoriaDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());//e=todos los elementos de la lista ->=remover
        }
        return lista;
        }
    
    @Override
    @Transactional
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
}
