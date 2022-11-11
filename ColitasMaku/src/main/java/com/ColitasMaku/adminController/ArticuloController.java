/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ColitasMaku.adminController;

import com.ColitasMaku.adminDomain.Articulo;
import com.ColitasMaku.adminService.ArticuloService;
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
public class ArticuloController {
        
    @Autowired
    private ArticuloService articuloService;
    
        @GetMapping("/admin/articulo/listado")
    public String listado(Model model) {
        var articulos=articuloService.getArticulos();
        model.addAttribute("articulos",articulos);
        return "/admin/articulo/listado";
    }

    @GetMapping("/admin/articulo/nuevo")
    public String articuloNuevo(Articulo articulo) {
        return "/admin/articulo/modificar";
    }
    
    @PostMapping("/admin/articulo/guardar")
    public String articuloGuardar(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/admin/articulo/listado";
    }
    
    @GetMapping("/admin/articulo/modificar/{idArticulo}")
    public String articuloModificar(Articulo articulo, Model model) {
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo",articulo);
        return "/admin/articulo/modificar";
    }
    
    @GetMapping("/admin/articulo/eliminar/{idArticulo}")
    public String articuloEliminar(Articulo articulo, Model model) {
        articuloService.delete(articulo);
        return "redirect:/admin/articulo/listado";
    }
}
