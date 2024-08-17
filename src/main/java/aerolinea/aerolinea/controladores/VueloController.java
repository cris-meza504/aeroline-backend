package aerolinea.aerolinea.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aerolinea.aerolinea.modelos.Vuelo;
import aerolinea.aerolinea.servicios.VueloServicio;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/vuelo")
public class VueloController {

    @Autowired
    private VueloServicio vueloServicio;
    
    @GetMapping("/obtener")
    public List<Vuelo> obtenerVuelos(){
       return this.vueloServicio.obtenerVuelos();
    }
}
