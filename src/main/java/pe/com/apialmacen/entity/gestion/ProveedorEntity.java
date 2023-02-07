package pe.com.apialmacen.entity.gestion;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
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
@Entity(name="ProveedorEntity") //define el nombre de la entidad
@Table(name="proveedor") //define el nombre de la tabla
public class ProveedorEntity extends EntityBase implements Serializable{
    private static final long serialVersionUID=1L;
    @Id //representa la clave primaria
    @Column(name="codprove")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremento
    private long codigo;
    //Colum define la columa de la tabla donde:
    

    @Column(name="nomprove",length = 40, nullable = false)
    @NotEmpty(message = "Debe de ingresar el nombre")
    private String nombre;
    
    @Column(name="guiaprove",length = 40, nullable = false)
    @NotEmpty(message = "Debe de ingresar la guia")
    private String guia;
    
    @Column(name="teleprove",length = 40, nullable = false)
    @NotEmpty(message = "Debe de ingresar el telefono")
    private String telefono;
    
    @Column(name="estprove",length = 40, nullable = false)
    @NotEmpty(message = "Debe de ingresar el estado")
    private String estado;

}
