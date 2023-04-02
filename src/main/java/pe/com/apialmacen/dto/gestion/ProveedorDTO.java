package pe.com.apialmacen.dto.gestion;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.apialmacen.dto.generic.GenericoDTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

@SuperBuilder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"codigo","nombre","telefono","direccion","correo","estado"})
public class ProveedorDTO extends GenericoDTO{
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;
    private Boolean estado;
}
