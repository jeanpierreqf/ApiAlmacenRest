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
import pe.com.apialmacen.dto.gestion.EntradaDetalleDTO;
import pe.com.apialmacen.entity.gestion.EntradaDetalleEntity;
import pe.com.apialmacen.service.gestion.EntradaDetalleService;


@RestController
@RequestMapping("/entradadetalle")
public class EntradaDetalleRestController {
    
    @Autowired
    private EntradaDetalleService servicio;


    @GetMapping
    public List<EntradaDetalleDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<EntradaDetalleDTO> findAllCustom() {
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public EntradaDetalleDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public EntradaDetalleDTO add(@RequestBody EntradaDetalleDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public EntradaDetalleDTO update(@PathVariable long id, @RequestBody EntradaDetalleDTO c) {
        c.getCodigo();
        return servicio.update(c);
    }

    @DeleteMapping("/{id}")
    public EntradaDetalleDTO delete(@PathVariable long id) {
        EntradaDetalleDTO objcategoria = new EntradaDetalleDTO();
        objcategoria.setCodigo(id);
        return servicio.delete(EntradaDetalleDTO.builder().codigo(id).build());
    }

    @PutMapping("/enable/{id}")
    public EntradaDetalleDTO enable(@PathVariable long id) {
        EntradaDetalleDTO objcategoria = new EntradaDetalleDTO();
        objcategoria.setCodigo(id);
        return servicio.enable(EntradaDetalleDTO.builder().codigo(id).build());
    }

}
