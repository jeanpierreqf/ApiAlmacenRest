package pe.com.apialmacen.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RutaController {

    @GetMapping()
    public String MostrarInicio() {
        return "index";
    }

    @GetMapping("/mostrarcategoria")
    public String MostrarCategoria() {
        return "/categoria/mostrarcategoria";
    }

    @GetMapping("/mostrarproducto")
    public String MostrarProducto() {
        return "/producto/mostrarproducto";
    }

    @GetMapping("/principal")
    public String MostrarMenuPrincipal() {
        return "principal";
    }
    
    @GetMapping("/entradaDetalle")
    public String MostrarEntradaDetalle() {
        return "entradaDetalle/entradaDetalle";
    }
    
    @GetMapping("/entrada")
    public String MostrarEntrada() {
        return "entrada/entrada";
    }
    
    @GetMapping("/proveedor")
    public String MostrarProveedor() {
        return "proveedor/proveedor";
    }
    
    @GetMapping("/roles")
    public String MostrarRoles() {
        return "roles/roles";
    }
    
    @GetMapping("/salidaDetalle")
    public String MostrarSalidaDetalle() {
        return "salidaDetalle/salidaDetalle";
    }
    
    @GetMapping("/salida")
    public String MostrarSalida() {
        return "salida/salida";
    }
    
    @GetMapping("/usuarios")
    public String MostrarUsuarios() {
        return "usuarios/usuarios";
    }
}
