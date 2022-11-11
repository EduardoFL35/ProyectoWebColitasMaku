/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ColitasMaku.adminDomain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Jostin Pizarro
 */
@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
        
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private long idUsuario;
    String nombre;
    String usuario;
    String contrasena;
    String correo;
    String telefono;


    public Usuario() {
    }

    public Usuario(String nombre, String usuario, String contrasena, String correo, String telefono) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
    }

    

   

    
}
