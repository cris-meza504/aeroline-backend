package aerolinea.aerolinea.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aerolinea.aerolinea.modelos.Pasajero;
import aerolinea.aerolinea.servicios.PasajeroServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/pasajero")
public class PasajeroController {
    
    @Autowired
    private PasajeroServicio pasajeroServicio;

    @GetMapping("/obtener/todos")
    public List<Pasajero> obtenerPasajeros() {
        return this.pasajeroServicio.obtenerPasajeros();
    }

    @PostMapping("/crear")
    public Pasajero creaPasajero(@RequestBody Pasajero pasajero) {
        
        return this.pasajeroServicio.crearPasajero(pasajero);
    }
    
    
}
