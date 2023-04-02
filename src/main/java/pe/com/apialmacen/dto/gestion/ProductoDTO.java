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
import pe.com.apialmacen.entity.gestion.ProductoEntity;

//@JsonPropertyOrder({"codigo","nombre","preciocompra","precioventa","cantidad","categoria","estado"})

@SuperBuilder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"codigo","nombre","estado"})
public class ProductoDTO extends GenericoDTO{
    private String nombre;
    private double preciocompra;
    private double precioventa;
    private int cantidad;
    private boolean estado;
    private ProductoEntity categoria;
}
