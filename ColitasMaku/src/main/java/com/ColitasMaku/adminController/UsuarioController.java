/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ColitasMaku.adminController;

import com.ColitasMaku.adminDomain.Usuario;
import com.ColitasMaku.adminService.UsuarioService;
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
    
     @GetMapping("/admin/usuario/listado")
    public String listado(Model model) {
        var usuarios = usuarioService.getUsuarios();

        model.addAttribute("usuarios", usuarios);
        return "/admin/usuario/listado";
    }

    @GetMapping("/admin/usuario/nuevo")
    public String usuarioNuevo(Usuario usuario) {
        return "/admin/usuario/modificar";
    }

    @PostMapping("/admin/usuario/guardar")
    public String usuarioGuardar(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/admin/usuario/listado";
    }

    @GetMapping("/admin/usuario/modificar/{idUsuario}")//
    public String usuarioModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/admin/usuario/modificar";
    }

    @GetMapping("/admin/usuario/eliminar/{idUsuario}")//
    public String usuarioEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/admin/usuario/listado";
    }   
}
