/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ColitasMaku.Controller;

import com.ColitasMaku.Domain.Usuario;
import com.ColitasMaku.Service.UsuarioService;
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
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
     @GetMapping("/usuario/listado")
    public String listado(Model model) {
        var usuarios = usuarioService.getUsuarios();

        model.addAttribute("usuarios", usuarios);
        return "/usuario/listado";
    }

    @GetMapping("/usuario/nuevo")
    public String usuarioNuevo(Usuario usuario) {
        return "/usuario/modificar";
    }

    @PostMapping("/usuario/guardar")
    public String usuarioGuardar(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/usuario/modificar/{idUsuario}")//
    public String usuarioModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modificar";
    }

    @GetMapping("/usuario/eliminar/{idUsuario}")//
    public String usuarioEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
    }   
}
