/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
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
@Entity(name="ProductoEntity") 
@Table(name="producto") 
public class ProductoEntity extends EntityBase implements  Serializable{
    private static final long serialVersionUID=1L;
    @Id 
    @Column(name="codproo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    
    @Column(name="nomproo",length = 40, nullable = false)
    @NotEmpty(message = "Debe de ingresar el nombre")
    private String nombre;
    
    
    @Column(name="canproo",nullable = false)
    @Positive(message = "Debe de ingresar la cantidad de cajas")//permita valores positivos
    private double cantidad;
    
    @Column(name="tamproo",nullable = false)
    @Positive(message = "Debe de ingresar el tamaño de la caja x unidad")
    private double tamano;
    
    @Column(name="pesproo",nullable = false)
    @Positive(message = "Debe de ingresar el precio general")//permite valores positivos o cero
    private int peso;
    
     @Column(name="stoproo",nullable = false)
    @Positive(message = "Debe de ingresar el stock x unidad de caja")//permite valores positivos o cero
    private int stock;
     
      @Column(name="desrecproo",nullable = false)
    @Positive(message = "Poner lugar donde se entrego el producto")//permite valores positivos o cero
    private int destinorecepcion;
      
       @Column(name="desproproo",nullable = false)
    @Positive(message = "Poner lugar donde se enviara el producto")//permite valores positivos o cero
    private int destinoprocedencia;
       
        @Column(name="preuniproo",nullable = false)
    @Positive(message = "Debe de ingresar el precio del producto x unidad")//permite valores positivos o cero
    private int preciounidad;
        

    @ManyToOne //relacion de uno a muchos
    @JoinColumn(name="codprove",nullable = false)
    private ProveedorEntity proveedor;
    
    @Column(name="estproo",nullable = false)
    @Positive(message = "Debe de ingresar el estado")//permite valores positivos o cero
    private int estado;
}
