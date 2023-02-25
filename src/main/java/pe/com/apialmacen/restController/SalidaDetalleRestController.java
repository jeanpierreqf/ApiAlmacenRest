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
import pe.com.apialmacen.entity.gestion.SalidaDetalleEntity;
import pe.com.apialmacen.service.gestion.SalidaDetalleService;

@RestController
@RequestMapping("/salidadetalle")
public class SalidaDetalleRestController {
    
    @Autowired
    private SalidaDetalleService servicio;
    
    @GetMapping
    public List<SalidaDetalleEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<SalidaDetalleEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @PostMapping
    public SalidaDetalleEntity add(@RequestBody SalidaDetalleEntity d){
        return servicio.add(d);
    }
    
    @GetMapping("/{id}")
    public Optional<SalidaDetalleEntity> findById(@PathVariable long id){
        return servicio.findById(id);
    }
    
    @PutMapping("/{id}")
    public SalidaDetalleEntity update(@PathVariable long id,@RequestBody SalidaDetalleEntity d){
        d.getCodigo();
        return servicio.update(d);
    }
    
    @DeleteMapping("/{id}")
    public SalidaDetalleEntity delete(@PathVariable long id){
        SalidaDetalleEntity objsalida=new SalidaDetalleEntity();
        objsalida.setCodigo(id);
        return servicio.delete(SalidaDetalleEntity.builder().codigo(id).build());
    }
    
}
