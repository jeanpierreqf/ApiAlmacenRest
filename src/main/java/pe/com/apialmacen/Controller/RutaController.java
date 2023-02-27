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
import pe.com.apialmacen.entity.gestion.RolesEntity;
import pe.com.apialmacen.service.gestion.CategoriaService;
import pe.com.apialmacen.service.gestion.ProductoService;
import pe.com.apialmacen.service.gestion.ProveedorService;
import pe.com.apialmacen.service.gestion.RolesService;

@Controller
public class RutaController {

    @Autowired
    private CategoriaService serviciocategoria;

    @Autowired
    private ProductoService servicioproducto;
    
    @Autowired
    private RolesService servicioroles;
    
    @Autowired
    private ProveedorService servicioproveedor;

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
    @GetMapping("/mostrarroles")
    public String MostrarRoles(Model modelo) {
        modelo.addAttribute("roles", servicioroles.findAllCustom());
        return "/roles/mostrarroles";
    }
    
    @GetMapping("mostrarproveedor")
    public String MostrarProveedor(Model modelo) {
        modelo.addAttribute("proveedor", servicioproveedor.findAllCustom());
        return "/proveedor/mostrarproveedor";
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
    
    @GetMapping("/registroroles")
    public String MostrarRegistrarRoles() {
        return "/roles/registrarroles";
    }
    
    @GetMapping("/registrarproveedor")
    public String MostrarRegistrarProveedor(){
        return "/proveedor/registrarproveedor";
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
    
    @GetMapping("/actualizoroles/{id}")
    public String MostrarActualizarRoles(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("roles", servicioroles.findById(id).get());
        return "/roles/actualizarroles";
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
    
    @GetMapping("/habilitoroles")
    public String MostrarHabilitarRoles(Model modelo) {
        modelo.addAttribute("roles", servicioroles.findAll());
        return "/roles/habilitarroles";
    }

    @ModelAttribute("categoria")
    public CategoriaEntity ModeloCategoria() {
        return new CategoriaEntity();
    }

    @ModelAttribute("producto")
    public ProductoEntity ModeloProducto() {
        return new ProductoEntity();
    }
    
    @ModelAttribute("roles")
    public RolesEntity ModeloRoles() {
        return new RolesEntity();
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
    
    @PostMapping("/registrarroles")
    public String RegistroRoles(@ModelAttribute("roles") RolesEntity r) {
        servicioroles.add(r);
        return "redirect:/mostrarroles?correcto";
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
    
    @PostMapping("/actualizarroles/{id}")
    public String ActualizarRoles(@PathVariable Long id, @ModelAttribute("roles") RolesEntity r) {
        servicioroles.update(r);
        return "redirect:/mostrarroles?actualizo";
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
    
    @GetMapping("/eliminarroles/{id}")
    public String EliminarRoles(@PathVariable Long id, Model modelo) {
        RolesEntity objroles = servicioroles.findById(id).get();
        servicioroles.delete(objroles);
        return "redirect:/mostrarroles?elimino";
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
    
    @GetMapping("/habilitarroles/{id}")
    public String HabilitarRoles(@PathVariable Long id, Model modelo) {
        RolesEntity objroles = servicioroles.findById(id).get();
        servicioroles.enable(objroles);
        return "redirect:/mostrarroles?habilito";
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
    
    @GetMapping("/deshabilitarroles/{id}")
    public String Deshabilitarroles(@PathVariable Long id, Model modelo) {
        RolesEntity objroles = servicioroles.findById(id).get();
        servicioroles.delete(objroles);
        return "redirect:/mostrarroles?deshabilito";
    }
}
