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
@Entity(name="EntradaEntity") 
@Table(name="entrada") 
@JsonPropertyOrder({"codigo","usuario","proveedor","estado"})
public class EntradaEntity extends EntityBase implements Serializable{
    private static final long serialVersionUID=1L;
    @Id 
    @Column(name="codent")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    @ManyToOne 
    @JoinColumn(name="codusu",nullable = false)
    private UsuariosEntity usuario;
    
    @ManyToOne
    @JoinColumn(name="codprove",nullable = false)
    private ProveedorEntity proveedor;
    
}
