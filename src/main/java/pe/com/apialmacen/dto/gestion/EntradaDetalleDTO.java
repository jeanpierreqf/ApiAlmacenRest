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
import pe.com.apialmacen.entity.gestion.EntradaEntity;
import pe.com.apialmacen.entity.gestion.ProductoEntity;

@SuperBuilder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"codigo","cantidad","precio","producto","entrada","estado"})
public class EntradaDetalleDTO extends GenericoDTO {
    private boolean estado;
    private Integer cantidad;
    private double precio;
    private ProductoEntity producto;
    private EntradaEntity entrada;
}
