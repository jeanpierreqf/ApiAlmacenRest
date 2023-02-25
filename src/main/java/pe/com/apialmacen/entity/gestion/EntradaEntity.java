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
@Entity(name="EntradaEntity") 
@Table(name="entrada") 
public class EntradaEntity extends EntityBase implements Serializable{
    private static final long serialVersionUID=1L;
    @Id 
    @Column(name="codent")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @ManyToOne //relacion de uno a muchos  
    @JoinColumn(name="codpro",nullable = false)
    private ProductoEntity producto;
    @ManyToOne //relacion de uno a muchos m
    @JoinColumn(name="codusu",nullable = false)
    private UsuariosEntity usuarios;
    @ManyToOne //relacion de uno a muchos
    @JoinColumn(name="codentra",nullable = false)
    private EntradaDetalleEntity entradadetalle;
    
}
