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
import pe.com.apialmacen.dto.gestion.SalidaDTO;
import pe.com.apialmacen.entity.gestion.EntradaEntity;
import pe.com.apialmacen.entity.gestion.SalidaEntity;
import pe.com.apialmacen.service.gestion.SalidaService;

@RestController
@RequestMapping("/salida")
public class SalidaRestController {
    
    @Autowired
    private SalidaService servicio;


    @GetMapping
    public List<SalidaDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<SalidaDTO> findAllCustom() {
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public SalidaDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public SalidaDTO add(@RequestBody SalidaDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public SalidaDTO update(@PathVariable long id, @RequestBody SalidaDTO c) {
        c.getCodigo();
        return servicio.update(c);
    }

    @DeleteMapping("/{id}")
    public SalidaDTO delete(@PathVariable long id) {
        SalidaDTO objcategoria = new SalidaDTO();
        objcategoria.setCodigo(id);
        return servicio.delete(SalidaDTO.builder().codigo(id).build());
    }

    @PutMapping("/enable/{id}")
    public SalidaDTO enable(@PathVariable long id) {
        SalidaDTO objcategoria = new SalidaDTO();
        objcategoria.setCodigo(id);
        return servicio.enable(SalidaDTO.builder().codigo(id).build());
    }

}