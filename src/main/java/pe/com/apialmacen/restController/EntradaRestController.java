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
import pe.com.apialmacen.entity.gestion.EntradaEntity;
import pe.com.apialmacen.service.gestion.EntradaService;

@RestController
@RequestMapping("/entrada")
public class EntradaRestController {
    @Autowired
    private EntradaService servicio;
    
    @GetMapping
    public List<EntradaEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<EntradaEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @PostMapping
    public EntradaEntity add(@RequestBody EntradaEntity e){
        return servicio.add(e);
    }
    
    @GetMapping("/{id}")
    public Optional<EntradaEntity> findById(@PathVariable long id){
        return servicio.findById(id);
    }
    
    @PutMapping("/{id}")
    public EntradaEntity update(@PathVariable long id,@RequestBody EntradaEntity e){
        e.getCodigo();
        return servicio.update(e);
    }
    
    @DeleteMapping("/{id}")
    public EntradaEntity delete(@PathVariable long id){
        EntradaEntity objentrada=new EntradaEntity();
        objentrada.setCodigo(id);
        return servicio.delete(EntradaEntity.builder().codigo(id).build());
    }
    
}
