package pe.com.apialmacen.entity.gestion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Entity(name="ProveedorEntity") 
@Table(name="proveedor") 
public class ProveedorEntity extends EntityBase implements Serializable{
    private static final long serialVersionUID=1L;
    @Id 
    @Column(name="codprove")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name="nomprove",length = 60, nullable = false)
    @NotEmpty(message = "Debe de ingresar el nombre")
    @Size(min=5,max=40,message = "El nombre debe de tener como minimo {min} y maximo {max}")
    private String nombre;
    @Column(name="telepro",nullable = false)
    @Positive(message = "El telefono del proveedor")//permita valores positivos
    private int telefono;
    @Column(name="direprove",nullable = false)
    @NotEmpty(message = "La direccion del proveedor")
    private String direccion;
    @Column(name="correprove",nullable = false)
    @NotEmpty(message = "Correo del proveedor")//permite valores positivos o cero
    private String correo;
    

    
}
    

