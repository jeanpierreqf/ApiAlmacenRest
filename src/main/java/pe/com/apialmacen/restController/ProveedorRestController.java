package pe.com.apialmacen.restController;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.apialmacen.entity.gestion.ProveedorEntity;
import pe.com.apialmacen.service.gestion.ProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorRestController {
    @Autowired
    private ProveedorService servicio;
    
    @GetMapping
    public List<ProveedorEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<ProveedorEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @PostMapping
    public ProveedorEntity add(@RequestBody ProveedorEntity d){
        return servicio.add(d);
    }
    
    @GetMapping("/{id}")
    public Optional<ProveedorEntity> findById(@PathVariable long id){
        return servicio.findById(id);
    }
    
    @PutMapping("/{id}")
    public ProveedorEntity update(@PathVariable long id,@RequestBody ProveedorEntity d){
        d.getCodigo();
        return servicio.update(d);
    }
    
    @DeleteMapping("/{id}")
    public ProveedorEntity delete(@PathVariable long id){
        ProveedorEntity objproveedor=new ProveedorEntity();
        objproveedor.setCodigo(id);
        return servicio.delete(ProveedorEntity.builder().codigo(id).build());
    }
    
}

