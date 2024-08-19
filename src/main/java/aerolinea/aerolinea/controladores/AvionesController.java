package aerolinea.aerolinea.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aerolinea.aerolinea.modelos.Avion;
import aerolinea.aerolinea.modelos.Mantenimiento;
import aerolinea.aerolinea.servicios.AvionServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("api/avion")
public class AvionesController {
    
    @Autowired
    private AvionServicio avionServicio;

    @GetMapping("/obtener/todos")
    public List<Avion> obtenerAviones() {
        return this.avionServicio.obtnerAviones();
    }

    @PostMapping("/crear")
    public Avion crearAvion(@RequestBody Avion avion) {
        return this.avionServicio.crearAvion(avion);
    }
    

    @GetMapping("/obtener/{codigo}")
    public Avion getMethodName(@PathVariable long codigo) {
        return this.avionServicio.obtenerAvionporid(codigo);
    }

    @GetMapping("/obtener/mantenimientos/{codigoAvion}")
    public List<Mantenimiento> obtenerMantenimientosAvion(@PathVariable long codigoAvion ) {
        return this.avionServicio.obtenerMantenimientosPorAvion(codigoAvion);
    }
    
    
    
}
