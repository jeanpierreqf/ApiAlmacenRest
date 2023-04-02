/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.apialmacen.dto.gestion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.apialmacen.dto.generic.GenericoDTO;
import pe.com.apialmacen.entity.gestion.RolesEntity;

@SuperBuilder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"codigo","nombre","apellido","sexo","estado"})
public class UsuarioDTO extends GenericoDTO{
    private String nombre;
    private boolean estado;
    private String apellido;
    private String sexo;
    private String fecha;
    private String fechaingreso;
    private String contraseña;
    private RolesEntity roles;
}
