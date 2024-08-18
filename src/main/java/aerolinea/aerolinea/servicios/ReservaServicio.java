package aerolinea.aerolinea.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolinea.aerolinea.modelos.Reserva;
import aerolinea.aerolinea.repositorios.PasajeroRepositorio;
import aerolinea.aerolinea.repositorios.ReservaRepositorio;

@Service
public class ReservaServicio {
    
    @Autowired
    private ReservaRepositorio reservaRepositorio;

    @Autowired
    private PasajeroRepositorio pasajeroRepositorio;

    public List<Reserva> obtenerReserva(){
       return this.reservaRepositorio.findAll();
    }

    public Reserva crearReserva(Reserva reserva){
        return this.reservaRepositorio.save(reserva);
    }

    public Reserva asociarReservaPasajero(Long codigoPasajero, Reserva reserva){
        if (this.pasajeroRepositorio.existsById(codigoPasajero)) {
            reserva.setPasajero(this.pasajeroRepositorio.findById(codigoPasajero).get());
            return this.reservaRepositorio.save(reserva);
        }else{
            return null;
        }
    }
}
