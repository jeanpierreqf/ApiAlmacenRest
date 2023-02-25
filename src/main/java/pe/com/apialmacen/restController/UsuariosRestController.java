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
import pe.com.apialmacen.entity.gestion.UsuariosEntity;
import pe.com.apialmacen.service.gestion.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosRestController {
    @Autowired
    private UsuariosService servicio;
    
    @GetMapping
    public List<UsuariosEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<UsuariosEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @PostMapping
    public UsuariosEntity add(@RequestBody UsuariosEntity u){
        return servicio.add(u);
    }
    
    @GetMapping("/{id}")
    public Optional<UsuariosEntity> findById(@PathVariable long id){
        return servicio.findById(id);
    }
    
    @PutMapping("/{id}")
    public UsuariosEntity update(@PathVariable long id,@RequestBody UsuariosEntity u){
        u.getCodigo();
        return servicio.update(u);
    }
    
    @DeleteMapping("/{id}")
    public UsuariosEntity delete(@PathVariable long id){
        UsuariosEntity objusuarios=new UsuariosEntity();
        objusuarios.setCodigo(id);
        return servicio.delete(UsuariosEntity.builder().codigo(id).build());
    }
    
}
