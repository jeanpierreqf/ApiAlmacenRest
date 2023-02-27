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
    @GetMapping("/mostrarproveedor")
    public String MostrarProveedor() {
        return "/proveedor/mostrarproveedor";
    }
    @GetMapping("/mostrarroles")
    public String MostrarRoles() {
        return "/roles/mostrarroles";
    }
    @GetMapping("/mostrarusuarios")
    public String MostrarUsuarios() {
        return "/usuarios/mostrarusuarios";
    }
    @GetMapping("/mostrarentrada")
    public String MostrarEntrada() {
        return "/entrada/mostrarentrada";
    }
    
    @GetMapping("/mostrarentradadetalle")
    public String MostrarEntradaDetalle() {
        return "/entradadetalle/mostrarentradadetalle";
    }
    
    @GetMapping("/mostrarsalida")
    public String MostrarSalida() {
        return "/salida/mostrarsalida";
    }
    
    @GetMapping("/mostrarsalidadetalle")
    public String MostrarSalidaDetalle() {
        return "/salidadetalle/mostrarsalidadetalle";
    }
   

    @GetMapping("/principal")
    public String MostrarMenuPrincipal() {
        return "principal";
    }
    
    
    
    
   
}
