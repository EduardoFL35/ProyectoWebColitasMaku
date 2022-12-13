/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ColitasMaku.Controller;

import com.ColitasMaku.Domain.Articulo;
import com.ColitasMaku.Service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @GetMapping("/articulo/listaArticulos")
    public String listado(Model model) {
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        return "/articulo/listaArticulos";
    }

    @GetMapping("/admin/articulo/nuevo")
    public String articuloNuevo(Articulo articulo) {
        return "/admin/articulo/modificar";
    }

    @PostMapping("/admin/articulo/guardar")
    public String articuloGuardar(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listaArticulos";
    }

    @GetMapping("/articulo/modificar/{idArticulo}")
    public String articuloModificar(Articulo articulo, Model model) {
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modificar";
    }

    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String articuloEliminar(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/listaArticulos";
    }
    
        @GetMapping("/articulo/busqueda/{idCategoria}")
    public String buscarCategoria(Model model, Articulo articulo) {

        var articulos = articuloService.buscarPorIdCategoria(articulo.getIdCategoria());
        model.addAttribute("articulos", articulos);
        return "redirect:/articulo/listaArticulos";
    }
}
