package pe.com.apialmacen.entity.gestion;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import pe.com.apialmacen.entity.base.EntityBase;

public class RolesEntity extends EntityBase implements Serializable{
    private static final long serialVersionUID=1L;
    @Id 
    @Column(name="codprove")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name="nomprove",length = 30, nullable = false)
    @NotEmpty(message = "Debe de ingresar el nombre")
    @Size(min=5,max=40,message = "El nombre debe de tener como minimo {min} y maximo {max}")
    private String nombre;
    //pi pi pi pi pi
}
