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
@Entity(name="OfertasEntity") 
@Table(name="ofertas") 
public class OfertasEntity extends EntityBase implements Serializable{
    private static final long serialVersionUID=1L;
    @Id 
    @Column(name="codofe")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    
    @Column(name="nomofe",length = 40, nullable = false)
    @NotEmpty(message = "Debe de ingresar el nombre")
    @Size(min=5,max=40,message = "El nombre debe de tener como minimo {min} y maximo {max}")
    private String nombreoferta;
    
    
    @ManyToOne //relacion de uno a muchos
    @JoinColumn(name="codpro",nullable = false)
    private ProductoEntity producto;
    
    
        @ManyToOne //relacion de uno a muchos
    @JoinColumn(name="codcat",nullable = false)
    private CategoriaEntity categoria;
        
        @ManyToOne //relacion de uno a muchos
    @JoinColumn(name="codpro",nullable = false)
    private ProductoEntity producto;
     
}