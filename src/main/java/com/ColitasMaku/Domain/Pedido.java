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
@Table(name="pedido")
public class Pedido implements Serializable{
        
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pedido")
    private long idPedido;
    String nombreCliente;
    String apellidos;
    String articulo;
    String total;


    public Pedido() {
    }

    public Pedido(String nombreCliente, String apellidos, String articulo, String total) {
        this.nombreCliente = nombreCliente;
        this.apellidos = apellidos;
        this.articulo = articulo;
        this.total = total;
    }





    

   

    
}
