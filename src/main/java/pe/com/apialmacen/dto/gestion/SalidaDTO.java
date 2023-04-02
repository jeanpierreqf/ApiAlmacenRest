
package pe.com.apialmacen.dto.gestion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.apialmacen.dto.generic.GenericoDTO;
import pe.com.apialmacen.entity.gestion.UsuariosEntity;

@SuperBuilder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"codigo","destino","usuarios","estado"})
public class SalidaDTO extends GenericoDTO{
    private boolean estado;
    private String destino;
    private UsuariosEntity usuarios;
}
