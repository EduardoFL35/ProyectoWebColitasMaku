/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ColitasMaku.adminService;

import com.ColitasMaku.adminDao.CategoriaDao;
import com.ColitasMaku.adminDomain.Categoria;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Jostin Pizarro
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {
        
    @Autowired
    private CategoriaDao categoriaDao;
    

    @Override
    @Transactional
    public List<Categoria> getCategorias() {
        return (List<Categoria>)categoriaDao.findAll();
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
