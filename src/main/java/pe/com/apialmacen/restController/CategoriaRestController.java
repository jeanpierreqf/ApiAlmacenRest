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
import pe.com.apialmacen.entity.gestion.CategoriaEntity;
import pe.com.apialmacen.service.gestion.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaRestController {
    @Autowired
    private CategoriaService servicio;
    
    @GetMapping
    public List<CategoriaEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<CategoriaEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @PostMapping
    public CategoriaEntity add(@RequestBody CategoriaEntity c){
        return servicio.add(c);
    }
    
    @GetMapping("/{id}")
    public Optional<CategoriaEntity> findById(@PathVariable long id){
        return servicio.findById(id);
    }
    
    @PutMapping("/{id}")
    public CategoriaEntity update(@PathVariable long id,@RequestBody CategoriaEntity c){
        c.getCodigo();
        return servicio.update(c);
    }
    
    @DeleteMapping("/{id}")
    public CategoriaEntity delete(@PathVariable long id){
        CategoriaEntity objcategoria=new CategoriaEntity();
        objcategoria.setCodigo(id);
        return servicio.delete(CategoriaEntity.builder().codigo(id).build());
    }
    
}
