package aerolinea.aerolinea.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aerolinea.aerolinea.modelos.Mantenimiento;
import aerolinea.aerolinea.servicios.MantenimientoServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/mantenimiento")
public class MantenimientoController {
    
    @Autowired
    private MantenimientoServicio mantenimientoServicio;

    @GetMapping("/obtener/todos")
    public List<Mantenimiento> obtenerManteniminetos() {
        return this.mantenimientoServicio.obtenerMantenimientos();
    }

    @PostMapping("/asociar/{codigoAvion}")
    public Mantenimiento asociarManteniamientoAvion(@PathVariable long codigoAvion, @RequestBody Mantenimiento mantenimiento) {
        
        return this.mantenimientoServicio.asociarMantenimientoAvion(codigoAvion, mantenimiento);
    }
    
    
}
