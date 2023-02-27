package pe.com.apialmacen.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.apialmacen.entity.gestion.CategoriaEntity;
import pe.com.apialmacen.entity.gestion.ProductoEntity;
import pe.com.apialmacen.service.gestion.CategoriaService;
import pe.com.apialmacen.service.gestion.ProductoService;

@Controller
public class RutaController {

    @Autowired
    private CategoriaService serviciocategoria;

    @Autowired
    private ProductoService servicioproducto;

    @GetMapping()
    public String MostrarInicio() {
        return "index";
    }

    @GetMapping("/mostrarcategoria")
    public String MostrarCategoria(Model modelo) {
        modelo.addAttribute("categorias", serviciocategoria.findAllCustom());
        return "/categoria/mostrarcategoria";
    }

    @GetMapping("/mostrarproducto")
    public String MostrarProducto(Model modelo) {
        modelo.addAttribute("productos", servicioproducto.findAllCustom());
        return "/producto/mostrarproducto";
    }

    @GetMapping("/principal")
    public String MostrarMenuPrincipal() {
        return "principal";
    }

    @GetMapping("/registrocategoria")
    public String MostrarRegistrarCategoria() {
        return "/categoria/registrarcategoria";
    }

    @GetMapping("/registroproducto")
    public String MostrarRegistrarProducto(Model modelo) {
        modelo.addAttribute("categorias", serviciocategoria.findAllCustom());
        return "/producto/registrarproducto";
    }

    @GetMapping("/actualizocategoria/{id}")
    public String MostrarActualizarCategoria(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("categorias", serviciocategoria.findById(id).get());
        return "/categoria/actualizarcategoria";
    }

    @GetMapping("/actualizoproducto/{id}")
    public String MostrarActualizarProducto(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("categorias", serviciocategoria.findAllCustom());
        modelo.addAttribute("productos", servicioproducto.findById(id).get());
        return "/producto/actualizarproducto";
    }

    @GetMapping("/habilitocategoria")
    public String MostrarHabilitarCategoria(Model modelo) {
        modelo.addAttribute("categorias", serviciocategoria.findAll());
        return "/categoria/habilitarcategoria";
    }

    @GetMapping("/habilitoproducto")
    public String MostrarHabilitarProducto(Model modelo) {
        modelo.addAttribute("productos", servicioproducto.findAll());
        return "/producto/habilitarproducto";
    }

    @ModelAttribute("categoria")
    public CategoriaEntity ModeloCategoria() {
        return new CategoriaEntity();
    }

    @ModelAttribute("producto")
    public ProductoEntity ModeloProducto() {
        return new ProductoEntity();
    }

    @PostMapping("/registrarcategoria")
    public String RegistroCategoria(@ModelAttribute("categoria") CategoriaEntity c) {
        serviciocategoria.add(c);
        return "redirect:/mostrarcategoria?correcto";
    }

    @PostMapping("/registrarproducto")
    public String RegistroProducto(@ModelAttribute("producto") ProductoEntity p) {
        servicioproducto.add(p);
        return "redirect:/mostrarproducto?correcto";
    }

    @PostMapping("/actualizarcategoria/{id}")
    public String ActualizarCategoria(@PathVariable Long id, @ModelAttribute("categoria") CategoriaEntity c) {
        serviciocategoria.update(c);
        return "redirect:/mostrarcategoria?actualizo";
    }

    @PostMapping("/actualizarproducto/{id}")
    public String ActualizarProducto(@PathVariable Long id, @ModelAttribute("producto") ProductoEntity p) {
        servicioproducto.update(p);
        return "redirect:/mostrarproducto?actualizo";
    }

    @GetMapping("/eliminarcategoria/{id}")
    public String EliminarCategoria(@PathVariable Long id, Model modelo) {
        CategoriaEntity objcategoria = serviciocategoria.findById(id).get();
        serviciocategoria.delete(objcategoria);
        return "redirect:/mostrarcategoria?elimino";
    }

    @GetMapping("/eliminarproducto/{id}")
    public String EliminarProducto(@PathVariable Long id, Model modelo) {
        ProductoEntity objproducto = servicioproducto.findById(id).get();
        servicioproducto.delete(objproducto);
        return "redirect:/mostrarproducto?elimino";
    }

    @GetMapping("/habilitarcategoria/{id}")
    public String HabilitarCategoria(@PathVariable Long id, Model modelo) {
        CategoriaEntity objcategoria = serviciocategoria.findById(id).get();
        serviciocategoria.enable(objcategoria);
        return "redirect:/mostrarcategoria?habilito";
    }

    @GetMapping("/habilitarproducto/{id}")
    public String HabilitarProducto(@PathVariable Long id, Model modelo) {
        ProductoEntity objcurso = servicioproducto.findById(id).get();
        servicioproducto.enable(objcurso);
        return "redirect:/mostrarproducto?habilito";
    }

    @GetMapping("/deshabilitarcategoria/{id}")
    public String DeshabilitarCategoria(@PathVariable Long id, Model modelo) {
        CategoriaEntity objcategoria = serviciocategoria.findById(id).get();
        serviciocategoria.delete(objcategoria);
        return "redirect:/mostrarcategoria?deshabilito";
    }

    @GetMapping("/deshabilitarproducto/{id}")
    public String DeshabilitarPRoducto(@PathVariable Long id, Model modelo) {
        ProductoEntity objproducto = servicioproducto.findById(id).get();
        servicioproducto.delete(objproducto);
        return "redirect:/mostrarproducto?deshabilito";
    }
}
