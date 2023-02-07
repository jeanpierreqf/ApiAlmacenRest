/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.apialmacen.service.gestion;

import java.util.List;
import java.util.Optional;
import pe.com.apialmacen.entity.gestion.ProveedorEntity;

/**
 *
 * @author frank
 */
public interface ProveedorService {
    public List<ProveedorEntity> findAll();
    
    public List<ProveedorEntity> findAllCustom();
    
    public Optional<ProveedorEntity> findById(long id);
    
    public ProveedorEntity add(ProveedorEntity p);
    
    public ProveedorEntity update(ProveedorEntity p);
    
    public ProveedorEntity delete(ProveedorEntity p);

    
}
