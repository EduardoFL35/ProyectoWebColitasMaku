/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ColitasMaku.Controller;

import com.ColitasMaku.Domain.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.ColitasMaku.Service.PedidoService;

/**
 *
 * @author Jostin Pizarro
 */
@Controller
@Slf4j
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedido/listado")
    public String inicio(Model model) {
        var pedidos = pedidoService.getPedidos();
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("totalPedidos", pedidos.size());
        return "/pedido/listado";
    }

    @GetMapping("/pedido/nuevo")
    public String pedidoNuevo(Pedido pedido) {
        return "/pedido/modificar";
    }

    @PostMapping("/pedido/guardar")
    public String pedidoGuardar(Pedido pedido) {
        pedidoService.save(pedido);
        return "redirect:/pedido/listado";
    }

    @GetMapping("/pedido/modificar/{idPedido}")//
    public String pedidoModificar(Pedido pedido, Model model) {
        pedido = pedidoService.getPedido(pedido);
        model.addAttribute("pedido", pedido);
        return "/pedido/modificar";
    }

    @GetMapping("/pedido/eliminar/{idPedido}")//
    public String pedidoEliminar(Pedido pedido) {
        pedidoService.delete(pedido);
        return "redirect:/pedido/listado";
    }
}
