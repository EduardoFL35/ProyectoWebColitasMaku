package com.ColitasMaku.Domain;

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

@Data
@Entity
@Table(name="articulo")
public class Articulo implements Serializable{
        
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_articulo")
    private long idArticulo;
    String nombre;
    String descripcion;
    int precio;
    int cantidad;
    boolean activo;
    @Column(name="ruta_imagen")
    private String rutaImagen;
    

    public Articulo() {
    }

    public Articulo(String nombre, String descripcion, int precio, int cantidad, boolean activo,String rutaImagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.activo = activo;    
        this.rutaImagen = rutaImagen;
    }

    
}
