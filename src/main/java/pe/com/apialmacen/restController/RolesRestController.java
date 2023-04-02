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
import pe.com.apialmacen.dto.gestion.RolesDTO;
import pe.com.apialmacen.entity.gestion.ProveedorEntity;
import pe.com.apialmacen.entity.gestion.RolesEntity;
import pe.com.apialmacen.service.gestion.RolesService;

@RestController
@RequestMapping ("/roles")
public class RolesRestController {
    @Autowired
    private RolesService servicio;


    @GetMapping
    public List<RolesDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<RolesDTO> findAllCustom() {
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public RolesDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public RolesDTO add(@RequestBody RolesDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public RolesDTO update(@PathVariable long id, @RequestBody RolesDTO c) {
        c.getCodigo();
        return servicio.update(c);
    }

    @DeleteMapping("/{id}")
    public RolesDTO delete(@PathVariable long id) {
        RolesDTO objcategoria = new RolesDTO();
        objcategoria.setCodigo(id);
        return servicio.delete(RolesDTO.builder().codigo(id).build());
    }

    @PutMapping("/enable/{id}")
    public RolesDTO enable(@PathVariable long id) {
        RolesDTO objcategoria = new RolesDTO();
        objcategoria.setCodigo(id);
        return servicio.enable(RolesDTO.builder().codigo(id).build());
    }

}