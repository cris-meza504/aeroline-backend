package aerolinea.aerolinea.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aerolinea.aerolinea.modelos.Reserva;
import aerolinea.aerolinea.servicios.ReservaServicio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/reserva")
public class ReservaController {

    @Autowired
    private ReservaServicio reservaServicio;
    
    @GetMapping("/obtener/todos")
    public List<Reserva> obtenerReserva() {
        return this.reservaServicio.obtenerReserva();
    }

    @PostMapping("/crear")
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        
        return this.reservaServicio.crearReserva(reserva);
    }


    @PostMapping("/asociar/{codigo}")
    public Reserva asociarReservaPasajero(@PathVariable Long codigo,@RequestBody Reserva reserva) {
        return this.reservaServicio.asociarReservaPasajero(codigo,reserva);
    }
    
    
    

}
