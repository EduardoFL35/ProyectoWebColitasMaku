/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ColitasMaku.adminService;

import com.ColitasMaku.adminDao.ArticuloDao;
import com.ColitasMaku.adminDomain.Articulo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Jostin Pizarro
 */
@Service
public class ArticuloServiceImpl implements ArticuloService {
        
    @Autowired
    private ArticuloDao articuloDao;
    

    @Override
    @Transactional
    public List<Articulo> getArticulos() {
        return (List<Articulo>)articuloDao.findAll();
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
