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
    
    
    
    
   
}
