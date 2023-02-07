package pe.com.apialmacen.entity.gestion;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Entity(name="ProductoEntity") 
@Table(name="producto") 
public class ProductoEntity extends EntityBase implements  Serializable{
    private static final long serialVersionUID=1L;
    @Id 
    @Column(name="codpro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name="nompro",length = 40, nullable = false)
    @NotEmpty(message = "Debe de ingresar el nombre")
    @Size(min=5,max=40,message = "El nombre debe de tener como minimo {min} y maximo {max}")
    private String nombre;
    @Column(name="precpro",nullable = false)
    @Positive(message = "El precio debe de ser mayor a 0")//permita valores positivos
    private double preciocompra;
    @Column(name="prevpro",nullable = false)
    @Positive(message = "El precio debe de ser mayor a 0")
    private double precioventa;
    @Column(name="canpro",nullable = false)
    @PositiveOrZero(message = "La cantidad debe de ser mayor o igual a cero")//permite valores positivos o cero
    private int cantidad;
    @ManyToOne //relacion de uno a muchos
    @JoinColumn(name="codcat",nullable = false)
    private CategoriaEntity categoria;
}
