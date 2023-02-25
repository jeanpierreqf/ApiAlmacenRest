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
import pe.com.apialmacen.entity.gestion.RolesEntity;
import pe.com.apialmacen.service.gestion.RolesService;

@RestController
@RequestMapping ("/roles")



public class RolesRestController {
    @Autowired
    private RolesService servicio;
    
    @GetMapping
    public List<RolesEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<RolesEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @PostMapping
    public RolesEntity add(@RequestBody RolesEntity r){
        return servicio.add(r);
    }
    
    @GetMapping("/{id}")
    public Optional<RolesEntity> findById(@PathVariable long id){
        return servicio.findById(id);
    }
    
    @PutMapping("/{id}")
    public RolesEntity update(@PathVariable long id,@RequestBody RolesEntity r){
        r.getCodigo();
        return servicio.update(r);
    }
    
    @DeleteMapping("/{id}")
    public RolesEntity delete(@PathVariable long id){
        RolesEntity objroles=new RolesEntity();
        objroles.setCodigo(id);
        return servicio.delete(RolesEntity.builder().codigo(id).build());
    }
    
}
