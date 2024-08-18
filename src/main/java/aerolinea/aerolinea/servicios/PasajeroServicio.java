package aerolinea.aerolinea.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolinea.aerolinea.modelos.Pasajero;
import aerolinea.aerolinea.modelos.Reserva;
import aerolinea.aerolinea.repositorios.PasajeroRepositorio;

@Service
public class PasajeroServicio {
    
     @Autowired
    private PasajeroRepositorio pasajeroRepositorio;

    public List<Pasajero> obtenerPasajeros(){
        return this.pasajeroRepositorio.findAll();
    }

    public Pasajero crearPasajero(Pasajero pasajero){
        if (this.pasajeroRepositorio.existsById(pasajero.getCodigoPasajero())) {
            return null;
        }else{
            if (pasajero.getReservas() != null) {
                List<Reserva> reservas = pasajero.getReservas();
                for (Reserva reserva : reservas) {
                    reserva.setPasajero(pasajero);
                }
            }
           return this.pasajeroRepositorio.save(pasajero);
        }
    }
}
