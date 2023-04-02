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
import pe.com.apialmacen.dto.gestion.CategoriaDTO;
import pe.com.apialmacen.service.gestion.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaRestController {

    @Autowired
    private CategoriaService servicio;


    @GetMapping
    public List<CategoriaDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<CategoriaDTO> findAllCustom() {
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public CategoriaDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public CategoriaDTO add(@RequestBody CategoriaDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public CategoriaDTO update(@PathVariable long id, @RequestBody CategoriaDTO c) {
        c.getCodigo();
        return servicio.update(c);
    }

    @DeleteMapping("/{id}")
    public CategoriaDTO delete(@PathVariable long id) {
        CategoriaDTO objcategoria = new CategoriaDTO();
        objcategoria.setCodigo(id);
        return servicio.delete(CategoriaDTO.builder().codigo(id).build());
    }

    @PutMapping("/enable/{id}")
    public CategoriaDTO enable(@PathVariable long id) {
        CategoriaDTO objcategoria = new CategoriaDTO();
        objcategoria.setCodigo(id);
        return servicio.enable(CategoriaDTO.builder().codigo(id).build());
    }

}
