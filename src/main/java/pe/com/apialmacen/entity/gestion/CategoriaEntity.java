package pe.com.apialmacen.entity.gestion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
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
@Entity(name="CategoriaEntity") //define el nombre de la entidad
@Table(name="categoria") //define el nombre de la tabla
public class CategoriaEntity extends EntityBase implements Serializable{
    private static final long serialVersionUID=1L;
    @Id //representa la clave primaria
    @Column(name="codcat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremento
    private long codigo;
    //Colum define la columa de la tabla donde:
    //name: es el nombre, length: tamaño y nullable: si permite valores nulos
    @Column(name="nomcat",length = 40, nullable = false)
    //validacion para que el campo no se vacio
    @NotEmpty(message = "Debe de ingresar el nombre")
    //validacion para controlar el tamaño del ingreso de datos
    @Size(min=5,max=40,message = "El nombre debe de tener como minimo {min} y maximo {max}")
    private String nombre;
}