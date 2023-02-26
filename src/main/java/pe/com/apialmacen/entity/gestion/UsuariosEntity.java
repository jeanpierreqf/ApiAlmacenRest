package pe.com.apialmacen.entity.gestion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.apialmacen.entity.base.EntityBase;


@SuperBuilder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name="UsuariosEntity") 
@Table(name="usuarios") 
public class UsuariosEntity extends EntityBase implements Serializable{
    private static final long serialVersionUID=1L;
    @Id 
    @Column(name="codusu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name="nombem",length = 100, nullable = false)
    @NotEmpty(message = "Debe de ingresar el nombre del empleado")
    @Size(min=5,max=40,message = "El nombre debe de tener como minimo {min} y maximo {max}")
    private String nombre;
    @Column(name="apelliem",length = 100, nullable = false)
    @Positive(message = "El telefono del proveedor")
    private String apellido;
    @Column(name="sexoem",length = 100, nullable = false)
    @Positive(message = "La direccion del proveedor")
    private String sexo;
    @Column(name="fnaciemp",nullable = false)
    @Positive(message = "fecha de nacimiento")
    private String fecha;
    @Column(name="finemp",nullable = false)
    @Positive(message = "fecha de ingreso")
    private String fechaingreso;
    @Column(name="contem",nullable = false)
    @Positive(message = "contrasena del empleado")
    private String contraseña;
   
}
