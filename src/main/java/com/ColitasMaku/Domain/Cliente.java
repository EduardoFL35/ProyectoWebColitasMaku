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
@Table(name="cliente")
public class Cliente implements Serializable{
        
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private long idCliente;
    String nombre;
    String apellidos;
    String correo;
    String telefono;


    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }



    

   

    
}
