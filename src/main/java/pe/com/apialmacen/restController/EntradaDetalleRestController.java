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
import pe.com.apialmacen.entity.gestion.EntradaDetalleEntity;
import pe.com.apialmacen.service.gestion.EntradaDetalleService;


@RestController
@RequestMapping("/entradadetalle")
public class EntradaDetalleRestController {
    
    @Autowired
    private EntradaDetalleService servicio;
    
    @GetMapping
    public List<EntradaDetalleEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<EntradaDetalleEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @PostMapping
    public EntradaDetalleEntity add(@RequestBody EntradaDetalleEntity ed){
        return servicio.add(ed);
    }
    
    @GetMapping("/{id}")
    public Optional<EntradaDetalleEntity> findById(@PathVariable long id){
        return servicio.findById(id);
    }
    
    @PutMapping("/{id}")
    public EntradaDetalleEntity update(@PathVariable long id,@RequestBody EntradaDetalleEntity ed){
        ed.getCodigo();
        return servicio.update(ed);
    }
    
    @DeleteMapping("/{id}")
    public EntradaDetalleEntity delete(@PathVariable long id){
        EntradaDetalleEntity objsalida=new EntradaDetalleEntity();
        objsalida.setCodigo(id);
        return servicio.delete(EntradaDetalleEntity.builder().codigo(id).build());
    }
    
}
