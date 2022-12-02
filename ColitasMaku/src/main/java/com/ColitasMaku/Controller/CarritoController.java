/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ColitasMaku.Controller;

import com.ColitasMaku.Domain.Articulo;
import com.ColitasMaku.Domain.Item;
import com.ColitasMaku.Service.ArticuloService;
import com.ColitasMaku.Service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jostin Pizarro
 */
@Controller
@Slf4j
public class CarritoController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var items = itemService.getItems();
        model.addAttribute("items", items);
        var carritoTotalVenta = 0;
        for (Item c : items) {
            carritoTotalVenta += (c.getCantidad() * c.getPrecio());
        }
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return "/carrito/listado";
    }

    @GetMapping("/carrito/agregar/{idArticulo}")
    public ModelAndView agregarArticulo(Model model, Item item) {
        Item item2 = itemService.getItem(item);
        if (item2 == null) {
            Articulo articulo = articuloService.getArticulo(item);
            item2 = new Item(articulo);
        }
        itemService.save(item2);
        var lista = itemService.getItems();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentosCarrito :: verCarrito");
    }

    @GetMapping("/carrito/modificar/{idArticulo}")
    public String modificarCarrito(Item item, Model model) {
        item = itemService.getItem(item);
        model.addAttribute("item", item);
        return "/carrito/modificar";
    }

    @GetMapping("/carrito/eliminar/{idArticulo}")
    public String eliminarItem(Item item) {
        itemService.delete(item);
        return "redirect:/carrito/listado";
    }

    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }

    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        itemService.facturar();
        return "redirect:/";
    }

}
