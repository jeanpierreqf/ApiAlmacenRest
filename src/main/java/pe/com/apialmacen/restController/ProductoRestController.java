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
import pe.com.apialmacen.entity.gestion.ProductoEntity;
import pe.com.apialmacen.service.gestion.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {
     @Autowired
    private ProductoService servicio;
    
    @GetMapping
    public List<ProductoEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<ProductoEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @PostMapping
    public ProductoEntity add(@RequestBody ProductoEntity p){
        return servicio.add(p);
    }
    
    @GetMapping("/{id}")
    public Optional<ProductoEntity> findById(@PathVariable long id){
        return servicio.findById(id);
    }
    
    @PutMapping("/{id}")
    public ProductoEntity update(@PathVariable long id,@RequestBody ProductoEntity p){
        p.getCodigo();
        return servicio.update(p);
    }
    
    @DeleteMapping("/{id}")
    public ProductoEntity delete(@PathVariable long id){
        ProductoEntity objproducto=new ProductoEntity();
        objproducto.setCodigo(id);
        return servicio.delete(ProductoEntity.builder().codigo(id).build());
    }
}