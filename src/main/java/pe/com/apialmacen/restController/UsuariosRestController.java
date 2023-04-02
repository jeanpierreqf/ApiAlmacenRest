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
import pe.com.apialmacen.dto.gestion.UsuarioDTO;
import pe.com.apialmacen.entity.gestion.UsuariosEntity;
import pe.com.apialmacen.service.gestion.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosRestController {
    @Autowired
    private UsuariosService servicio;


    @GetMapping
    public List<UsuarioDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<UsuarioDTO> findAllCustom() {
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public UsuarioDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public UsuarioDTO add(@RequestBody UsuarioDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public UsuarioDTO update(@PathVariable long id, @RequestBody UsuarioDTO c) {
        c.getCodigo();
        return servicio.update(c);
    }

    @DeleteMapping("/{id}")
    public UsuarioDTO delete(@PathVariable long id) {
        UsuarioDTO objcategoria = new UsuarioDTO();
        objcategoria.setCodigo(id);
        return servicio.delete(UsuarioDTO.builder().codigo(id).build());
    }

    @PutMapping("/enable/{id}")
    public UsuarioDTO enable(@PathVariable long id) {
        UsuarioDTO objcategoria = new UsuarioDTO();
        objcategoria.setCodigo(id);
        return servicio.enable(UsuarioDTO.builder().codigo(id).build());
    }

}