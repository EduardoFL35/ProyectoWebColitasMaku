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
@Table(name="categoria")
public class Categoria implements Serializable{
        
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private long idCategoria;
    String nombre;
    boolean activo;
    
   

    public Categoria() {
    }

    public Categoria(String nombre, boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

    

    
}
