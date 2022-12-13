package com.ColitasMaku.Domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "validacion")//Cuál tabla va a mapear
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id//Para mapear el ID de la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_validacion")
    private Long idValidacion;
    
    @NotEmpty
    String username;
    
    @NotEmpty
    String password;
    
    @OneToMany
    @JoinColumn(name="id_validacion")
    private List<Rol> roles;
    
}
