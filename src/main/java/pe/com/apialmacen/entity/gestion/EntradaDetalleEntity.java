
package pe.com.apialmacen.entity.gestion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
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
@Entity(name="EntradaDetalleEntity") 
@Table(name="entradadetalle") 
@JsonPropertyOrder({"codigo","cantidad","precio","producto","entrada","estado"})
public class EntradaDetalleEntity extends EntityBase implements Serializable {
    
    private static final long serialVersionUID=1L;
    @Id 
    @Column(name="codentra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    @Column(name="cantentrada",nullable = false)
    @Positive(message = "El telefono del proveedor")//permita valores positivos
    private int cantidad;
    
    @Column(name="preentrada",nullable = false)
    private double precio;
    
    @OneToOne //relacion de uno a muchos
    @JoinColumn(name="codpro",nullable = false)
    private ProductoEntity producto;
    
    @ManyToOne 
    @JoinColumn(name="codent",nullable = false)
    private EntradaEntity entrada;
}
