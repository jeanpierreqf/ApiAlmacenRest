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
import pe.com.apialmacen.dto.gestion.SalidaDetalleDTO;
import pe.com.apialmacen.entity.gestion.SalidaDetalleEntity;
import pe.com.apialmacen.service.gestion.SalidaDetalleService;

@RestController
@RequestMapping("/salidadetalle")
public class SalidaDetalleRestController {
    
    @Autowired
    private SalidaDetalleService servicio;


    @GetMapping
    public List<SalidaDetalleDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<SalidaDetalleDTO> findAllCustom() {
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public SalidaDetalleDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public SalidaDetalleDTO add(@RequestBody SalidaDetalleDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public SalidaDetalleDTO update(@PathVariable long id, @RequestBody SalidaDetalleDTO c) {
        c.getCodigo();
        return servicio.update(c);
    }

    @DeleteMapping("/{id}")
    public SalidaDetalleDTO delete(@PathVariable long id) {
        SalidaDetalleDTO objcategoria = new SalidaDetalleDTO();
        objcategoria.setCodigo(id);
        return servicio.delete(SalidaDetalleDTO.builder().codigo(id).build());
    }

    @PutMapping("/enable/{id}")
    public SalidaDetalleDTO enable(@PathVariable long id) {
        SalidaDetalleDTO objcategoria = new SalidaDetalleDTO();
        objcategoria.setCodigo(id);
        return servicio.enable(SalidaDetalleDTO.builder().codigo(id).build());
    }

}