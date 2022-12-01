package com.ColitasMaku.Service;

import com.ColitasMaku.Service.ArticuloService;
import com.ColitasMaku.Dao.ArticuloDao;
import com.ColitasMaku.Domain.Articulo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService {
        
    @Autowired
    private ArticuloDao articuloDao;
    

    @Override
    @Transactional
    public List<Articulo> getArticulos(boolean activos) {
        var lista=(List<Articulo>)articuloDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());//e=todos los elementos de la lista ->=remover
        }
        return lista;
    }
    
    @Override
    @Transactional
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }
}
