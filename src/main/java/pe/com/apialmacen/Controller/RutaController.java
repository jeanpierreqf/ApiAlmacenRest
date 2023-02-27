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
import pe.com.apialmacen.entity.gestion.ProveedorEntity;
import pe.com.apialmacen.entity.gestion.RolesEntity;
import pe.com.apialmacen.entity.gestion.SalidaDetalleEntity;
import pe.com.apialmacen.entity.gestion.UsuariosEntity;
import pe.com.apialmacen.service.gestion.CategoriaService;
import pe.com.apialmacen.service.gestion.ProductoService;
import pe.com.apialmacen.service.gestion.ProveedorService;
import pe.com.apialmacen.service.gestion.RolesService;
import pe.com.apialmacen.service.gestion.SalidaDetalleService;
import pe.com.apialmacen.service.gestion.UsuariosService;

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
    
    @Autowired
    private SalidaDetalleService serviciosalidadetalle;
    
    @Autowired
    private UsuariosService serviciousuarios;


    @GetMapping()
    public String MostrarInicio() {
        return "index";
    }
    @GetMapping("/mostrarusuarios")
    public String MostrarUsuarios(Model modelo) {
        modelo.addAttribute("usuarios", serviciousuarios.findAllCustom());
        return "/usuarios/mostrarusuarios";
    }

    @GetMapping("/mostrarcategoria")
    public String MostrarCategoria(Model modelo) {
        modelo.addAttribute("categorias", serviciocategoria.findAllCustom());
        return "/categoria/mostrarcategoria";
    }

    @GetMapping("/mostrarproducto")
    public String MostrarProducto(Model modelo) {
        modelo.addAttribute("producto", servicioproducto.findAllCustom());
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
    
    @GetMapping("/mostrarsalidadetalle")
    public String MostrarSalidadetalle(Model modelo) {
        modelo.addAttribute("salidadetalle", serviciosalidadetalle.findAllCustom());
        return "/salidadetalle/mostrarsalidadetalle";
    }

    @GetMapping("/principal")
    public String MostrarMenuPrincipal() {
        return "principal";
    }

    @GetMapping("/registrocategoria")
    public String MostrarRegistrarCategoria() {
        return "/categoria/registrarcategoria";
    }
    @GetMapping("/registrousuarios")
    public String MostrarRegistrarUsuarios(Model modelo) {
        modelo.addAttribute("roles", servicioroles.findAllCustom());
        return "/usuarios/registrarusuarios";
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
    
    @GetMapping("/registroproveedor")
    public String MostrarRegistrarProveedor(){
        return "/proveedor/registrarproveedor";
    }
    
    @GetMapping("/registrosalidadetalle")
    public String MostrarRegistrarSalidadetalle(){
        return "/salidadetalle/registrarsalidadetalle";
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
    
    @GetMapping("/actualizoproveedor/{id}")
    public String MostrarActualizarProveedor(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("roles", servicioproveedor.findById(id).get());
        return "/proveedor/actualizarproveedor";
    
    }

    @GetMapping("/actualizosalidadetalle/{id}")
    public String MostrarActualizarSalidadetalle(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("salidadetalle", serviciosalidadetalle.findById(id).get());
        return "/salidadetalle/actualizarsalidadetalle";
    }
    
    @GetMapping("/habilitocategoria")
    public String MostrarHabilitarCategoria(Model modelo) {
        modelo.addAttribute("categorias", serviciocategoria.findAll());
        return "/categoria/habilitarcategoria";
    }
    @GetMapping("/habilitousuarios")
    public String MostrarHabilitarUsuarios(Model modelo) {
        modelo.addAttribute("usuarios", serviciousuarios.findAll());
        return "/usuarios/habilitarusuarios";
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
    
    @GetMapping("/habilitoproveedor")
    public String MostrarHabilitarProveedor(Model modelo) {
        modelo.addAttribute("proveedor", servicioproveedor.findAll());
        return "/proveedor/habilitarproveedor";
    }
    
    @GetMapping("/habilitosalidadetalle")
    public String MostrarHabilitarSalidadetalle(Model modelo) {
        modelo.addAttribute("salidadetalle", serviciosalidadetalle.findAll());
        return "/salidadetalle/habilitarsalidadetalle";
    }

    @ModelAttribute("categoria")
    public CategoriaEntity ModeloCategoria() {
        return new CategoriaEntity();
    }
    @ModelAttribute("usuarios")
    public UsuariosEntity ModeloUsuarios() {
        return new UsuariosEntity();
    }

    @ModelAttribute("producto")
    public ProductoEntity ModeloProducto() {
        return new ProductoEntity();
    }
    
    @ModelAttribute("roles")
    public RolesEntity ModeloRoles() {
        return new RolesEntity();
    }
    
    @ModelAttribute("proveedor")
    public ProveedorEntity ModeloProveedor() {
        return new ProveedorEntity();
    }
    
    @ModelAttribute("salidadetale")
    public SalidaDetalleEntity ModeloSalidaDetalle() {
        return new SalidaDetalleEntity();
    }

    @PostMapping("/registrarcategoria")
    public String RegistroCategoria(@ModelAttribute("categoria") CategoriaEntity c) {
        serviciocategoria.add(c);
        return "redirect:/mostrarcategoria?correcto";
    }
    @PostMapping("/registrarusuarios")
    public String RegistroUsuarios(@ModelAttribute("usuarios") UsuariosEntity u) {
        serviciousuarios.add(u);
        return "redirect:/mostrarusuarios?correcto";
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
    
    @PostMapping("/registrarproveedor")
    public String RegistroProveedor(@ModelAttribute("proveedor") ProveedorEntity d) {
        servicioproveedor.add(d);
        return "redirect:/mostrarproveedor?correcto";
    }
    
    @PostMapping("/registrarsalidadetalle")
    public String RegistroSalidadetalle(@ModelAttribute("salidadetalle") SalidaDetalleEntity sd) {
        serviciosalidadetalle.add(sd);
        return "redirect:/mostrarsalidadetalle?correcto";
    }

    @PostMapping("/actualizarcategoria/{id}")
    public String ActualizarCategoria(@PathVariable Long id, @ModelAttribute("categoria") CategoriaEntity c) {
        serviciocategoria.update(c);
        return "redirect:/mostrarcategoria?actualizo";
    }
    @PostMapping("/actualizarusuarios/{id}")
    public String ActualizarUsuarios(@PathVariable Long id, @ModelAttribute("usuarios") UsuariosEntity u) {
        serviciousuarios.update(u);
        return "redirect:/mostrarusuarios?actualizo";
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
    
    @PostMapping("/actualizarproveedor/{id}")
    public String ActualizarProveedor(@PathVariable Long id, @ModelAttribute("proveedor") ProveedorEntity d) {
        servicioproveedor.update(d);
        return "redirect:/mostrarproveedor?actualizo";
    }
    
    @PostMapping("/actualizarsalidadetalle/{id}")
    public String ActualizarSalidadetalle(@PathVariable Long id, @ModelAttribute("salidadetalle") SalidaDetalleEntity sd) {
        serviciosalidadetalle.update(sd);
        return "redirect:/mostrarsalidadetalle?actualizo";
    }

    @GetMapping("/eliminarcategoria/{id}")
    public String EliminarCategoria(@PathVariable Long id, Model modelo) {
        CategoriaEntity objcategoria = serviciocategoria.findById(id).get();
        serviciocategoria.delete(objcategoria);
        return "redirect:/mostrarcategoria?elimino";
    }
    @GetMapping("/eliminarusuarios/{id}")
    public String EliminarUsuarios(@PathVariable Long id, Model modelo) {
       UsuariosEntity objusuarios = serviciousuarios.findById(id).get();
        serviciousuarios.delete(objusuarios);
        return "redirect:/mostrarusuarios?elimino";
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
    
    @GetMapping("/eliminarproveedor/{id}")
    public String EliminarProveedor(@PathVariable Long id, Model modelo) {
        ProveedorEntity objproveedor = servicioproveedor.findById(id).get();
        servicioproveedor.delete(objproveedor);
        return "redirect:/mostrarproveedor?elimino";
    }
    
    @GetMapping("/eliminarsalidadetalle/{id}")
    public String EliminarSalidadetalle(@PathVariable Long id, Model modelo) {
        SalidaDetalleEntity objsalidadetalle = serviciosalidadetalle.findById(id).get();
        serviciosalidadetalle.delete(objsalidadetalle);
        return "redirect:/mostrarsalidadetalle?elimino";
    }

    @GetMapping("/habilitarcategoria/{id}")
    public String HabilitarCategoria(@PathVariable Long id, Model modelo) {
        CategoriaEntity objcategoria = serviciocategoria.findById(id).get();
        serviciocategoria.enable(objcategoria);
        return "redirect:/mostrarcategoria?habilito";
    }
    @GetMapping("/habilitarusuarios/{id}")
    public String HabilitarUsuarios(@PathVariable Long id, Model modelo) {
        UsuariosEntity objusuarios = serviciousuarios.findById(id).get();
        serviciousuarios.enable(objusuarios);
        return "redirect:/mostrarusuarios?habilito";
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
    
    @GetMapping("/habilitarproveedor/{id}")
    public String HabilitarProveedor(@PathVariable Long id, Model modelo) {
        ProveedorEntity objproveedor = servicioproveedor.findById(id).get();
        servicioproveedor.enable(objproveedor);
        return "redirect:/mostrarproveedor?habilito";
    }
    
    @GetMapping("/habilitarsalidadetalle/{id}")
    public String HabilitarSalidadetalle(@PathVariable Long id, Model modelo) {
        SalidaDetalleEntity objsalidadetalle = serviciosalidadetalle.findById(id).get();
        serviciosalidadetalle.enable(objsalidadetalle);
        return "redirect:/mostrarsalidadetalle?habilito";
    }

    @GetMapping("/deshabilitarcategoria/{id}")
    public String DeshabilitarCategoria(@PathVariable Long id, Model modelo) {
        CategoriaEntity objcategoria = serviciocategoria.findById(id).get();
        serviciocategoria.delete(objcategoria);
        return "redirect:/mostrarcategoria?deshabilito";
    }
    @GetMapping("/deshabilitarusuarios/{id}")
    public String DeshabilitarUsuarios(@PathVariable Long id, Model modelo) {
        UsuariosEntity objusuarios = serviciousuarios.findById(id).get();
        serviciousuarios.delete(objusuarios);
        return "redirect:/mostrarusuarios?deshabilito";
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
    
    @GetMapping("/deshabilitarproveedor/{id}")
    public String DeshabilitarProveedor(@PathVariable Long id, Model modelo) {
        ProveedorEntity objproveedor = servicioproveedor.findById(id).get();
        servicioproveedor.delete(objproveedor);
        return "redirect:/mostrarproveedor?deshabilito";
    }
    
    @GetMapping("/deshabilitarsalidadetalle/{id}")
    public String DeshabilitarSalidadetalle(@PathVariable Long id, Model modelo) {
        SalidaDetalleEntity objsalidadetalle = serviciosalidadetalle.findById(id).get();
        serviciosalidadetalle.delete(objsalidadetalle);
        return "redirect:/mostrarsalidadetalle?deshabilito";
    }
}
