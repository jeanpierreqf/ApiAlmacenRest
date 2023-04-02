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
@Entity(name="SalidaEntity") 
@Table(name="salida") 
public class SalidaEntity extends EntityBase implements Serializable{
    private static final long serialVersionUID=1L;
    @Id 
    @Column(name="codsalid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    @Column(name="destino")
    private String destino;

    @ManyToOne //relacion de uno a muchos
    @JoinColumn(name="codusu",nullable = false)
    private UsuariosEntity usuarios;
 
}
