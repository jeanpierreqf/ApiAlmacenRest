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
import pe.com.apialmacen.dto.gestion.EntradaDTO;
import pe.com.apialmacen.entity.gestion.EntradaEntity;
import pe.com.apialmacen.service.gestion.EntradaService;

@RestController
@RequestMapping("/entrada")
public class EntradaRestController {
    
@Autowired
    private EntradaService servicio;


    @GetMapping
    public List<EntradaDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<EntradaDTO> findAllCustom() {
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public EntradaDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public EntradaDTO add(@RequestBody EntradaDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public EntradaDTO update(@PathVariable long id, @RequestBody EntradaDTO c) {
        c.getCodigo();
        return servicio.update(c);
    }

    @DeleteMapping("/{id}")
    public EntradaDTO delete(@PathVariable long id) {
        EntradaDTO objcategoria = new EntradaDTO();
        objcategoria.setCodigo(id);
        return servicio.delete(EntradaDTO.builder().codigo(id).build());
    }

    @PutMapping("/enable/{id}")
    public EntradaDTO enable(@PathVariable long id) {
        EntradaDTO objcategoria = new EntradaDTO();
        objcategoria.setCodigo(id);
        return servicio.enable(EntradaDTO.builder().codigo(id).build());
    }

}