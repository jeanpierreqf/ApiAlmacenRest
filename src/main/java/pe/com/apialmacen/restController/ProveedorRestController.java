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
import pe.com.apialmacen.dto.gestion.ProveedorDTO;
import pe.com.apialmacen.entity.gestion.ProveedorEntity;
import pe.com.apialmacen.service.gestion.ProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorRestController {
    @Autowired
    private ProveedorService servicio;


    @GetMapping
    public List<ProveedorDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<ProveedorDTO> findAllCustom() {
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public ProveedorDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public ProveedorDTO add(@RequestBody ProveedorDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public ProveedorDTO update(@PathVariable long id, @RequestBody ProveedorDTO c) {
        c.getCodigo();
        return servicio.update(c);
    }

    @DeleteMapping("/{id}")
    public ProveedorDTO delete(@PathVariable long id) {
        ProveedorDTO objcategoria = new ProveedorDTO();
        objcategoria.setCodigo(id);
        return servicio.delete(ProveedorDTO.builder().codigo(id).build());
    }

    @PutMapping("/enable/{id}")
    public ProveedorDTO enable(@PathVariable long id) {
        ProveedorDTO objcategoria = new ProveedorDTO();
        objcategoria.setCodigo(id);
        return servicio.enable(ProveedorDTO.builder().codigo(id).build());
    }

}