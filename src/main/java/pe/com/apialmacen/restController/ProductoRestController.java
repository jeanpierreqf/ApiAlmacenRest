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
import pe.com.apialmacen.dto.gestion.ProductoDTO;
import pe.com.apialmacen.entity.gestion.ProductoEntity;
import pe.com.apialmacen.service.gestion.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {
     @Autowired
    private ProductoService servicio;


    @GetMapping
    public List<ProductoDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<ProductoDTO> findAllCustom() {
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public ProductoDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public ProductoDTO add(@RequestBody ProductoDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public ProductoDTO update(@PathVariable long id, @RequestBody ProductoDTO c) {
        c.getCodigo();
        return servicio.update(c);
    }

    @DeleteMapping("/{id}")
    public ProductoDTO delete(@PathVariable long id) {
        ProductoDTO objcategoria = new ProductoDTO();
        objcategoria.setCodigo(id);
        return servicio.delete(ProductoDTO.builder().codigo(id).build());
    }

    @PutMapping("/enable/{id}")
    public ProductoDTO enable(@PathVariable long id) {
        ProductoDTO objcategoria = new ProductoDTO();
        objcategoria.setCodigo(id);
        return servicio.enable(ProductoDTO.builder().codigo(id).build());
    }

}