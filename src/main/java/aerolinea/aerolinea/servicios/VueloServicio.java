package aerolinea.aerolinea.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolinea.aerolinea.modelos.Avion;
import aerolinea.aerolinea.modelos.Pasajero;
import aerolinea.aerolinea.modelos.Reserva;
import aerolinea.aerolinea.modelos.Vuelo;
import aerolinea.aerolinea.repositorios.VueloRepositorio;

@Service
public class VueloServicio {
    
    @Autowired
    private VueloRepositorio vueloRepositorio;

    public List<Vuelo> obtenerVuelos(){
        return this.vueloRepositorio.findAll();
    }

    public Vuelo crearVuelo(Vuelo vuelo) {
        if (this.vueloRepositorio.existsById(vuelo.getCodigoVuelo())) {
            return null;
        } else {

            /*if (vuelo.getCiudadOrigen() == null) {
               
            }
            if (vuelo.getCiudadDestino() != null) {
                Ciudad ciudad = vuelo.getCiudadDestino();
                ciudad.getVuelosDestino().add(vuelo);
            }*/
            if (vuelo.getAvion() != null){
                Avion avion = vuelo.getAvion();
                vuelo.setAvion(avion);
            }
            if (vuelo.getPasajeros() != null) {
                for (Pasajero pasajero : vuelo.getPasajeros()) {
                    // Asocia el vuelo con el pasajero
                    if (pasajero.getVuelos() != null) {
                        pasajero.getVuelos().add(vuelo);
                          
                    }
                    if (pasajero.getReservas() != null) {
                        for (Reserva reserva : pasajero.getReservas()) {
                            //Asociar la reserva con el pasajero
                            reserva.setPasajero(pasajero);
                        }
                    }
                }
            }
            return this.vueloRepositorio.save(vuelo);
        }
    }
    
}
