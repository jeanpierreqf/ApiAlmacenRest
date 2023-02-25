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
import pe.com.apialmacen.entity.gestion.SalidaEntity;
import pe.com.apialmacen.service.gestion.SalidaService;

@RestController
@RequestMapping("/Salida")
public class SalidaRestController {
    
    @Autowired
    private SalidaService servicio;
    
    @GetMapping
    public List<SalidaEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<SalidaEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @PostMapping
    public SalidaEntity add(@RequestBody SalidaEntity e){
        return servicio.add(e);
    }
    
    @GetMapping("/{id}")
    public Optional<SalidaEntity> findById(@PathVariable long id){
        return servicio.findById(id);
    }
    
    @PutMapping("/{id}")
    public SalidaEntity update(@PathVariable long id,@RequestBody SalidaEntity e){
        e.getCodigo();
        return servicio.update(e);
    }
    
    @DeleteMapping("/{id}")
    public SalidaEntity delete(@PathVariable long id){
        SalidaEntity objsalida=new SalidaEntity();
        objsalida.setCodigo(id);
        return servicio.delete(SalidaEntity.builder().codigo(id).build());
    }
    
}
