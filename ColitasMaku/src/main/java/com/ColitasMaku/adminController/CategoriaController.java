/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ColitasMaku.adminController;

import com.ColitasMaku.adminDomain.Categoria;
import com.ColitasMaku.adminService.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Jostin Pizarro
 */
@Controller
@Slf4j
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    
        @GetMapping("/admin/categoria/listado")
    public String listado(Model model) {
        var categorias=categoriaService.getCategorias();
        model.addAttribute("categorias",categorias);
        return "/admin/categoria/listado";
    }

    @GetMapping("/admin/categoria/nuevo")
    public String categoriaNuevo(Categoria categoria) {
        return "/admin/categoria/modificar";
    }
    
    @PostMapping("/admin/categoria/guardar")
    public String categoriaGuardar(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/admin/categoria/listado";
    }
    
    @GetMapping("/admin/categoria/modificar/{idCategoria}")
    public String categoriaModificar(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria",categoria);
        return "/admin/categoria/modificar";
    }
    
    @GetMapping("/admin/categoria/eliminar/{idCategoria}")
    public String categoriaEliminar(Categoria categoria, Model model) {
        categoriaService.delete(categoria);
        return "redirect:/admin/categoria/listado";
    }
}
