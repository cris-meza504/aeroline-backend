package aerolinea.aerolinea.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aerolinea.aerolinea.modelos.Tripulacion;
import aerolinea.aerolinea.servicios.TripulacionServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/tripulacion")
public class TripulacionController {

    @Autowired
    private TripulacionServicio tripulacionServicio;
    
    @GetMapping("/obtener/todos")
    public List<Tripulacion> obtenerTripulacion() {
        return this.tripulacionServicio.obteneTripulacion();
    }

    @PostMapping("/crear")
    public Tripulacion crearTripulacion(@RequestBody Tripulacion tripulacion) {
        return this.tripulacionServicio.crearTripulacion(tripulacion);
    }

    @PostMapping("/asociarTripulacionVuelo/{codigoVuelo}")
    public Tripulacion asociarTripulacionVuelo(@PathVariable long codigoVuelo,@RequestBody Tripulacion tripulacion) {
        
        return this.tripulacionServicio.asociarTripulacionVuelo(codigoVuelo, tripulacion);
    }
    
    
    
}
