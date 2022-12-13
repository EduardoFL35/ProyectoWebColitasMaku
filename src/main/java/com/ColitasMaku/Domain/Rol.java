package com.ColitasMaku.Domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "rol")//Cuál tabla va a mapear
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id//Para mapear el ID de la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @NotEmpty
    String nombre;

}
