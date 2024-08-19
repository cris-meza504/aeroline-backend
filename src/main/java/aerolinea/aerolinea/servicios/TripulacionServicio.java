package aerolinea.aerolinea.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolinea.aerolinea.modelos.Tripulacion;
import aerolinea.aerolinea.modelos.Vuelo;
import aerolinea.aerolinea.repositorios.TripulacionRepositorio;
import aerolinea.aerolinea.repositorios.VueloRepositorio;

@Service
public class TripulacionServicio {
    
    @Autowired
    private TripulacionRepositorio tripulacionRepositorio;

    @Autowired
    private VueloRepositorio vueloRepositorio;

    public List<Tripulacion> obteneTripulacion(){
        return this.tripulacionRepositorio.findAll();
    }

    public Tripulacion crearTripulacion(Tripulacion tripulacion){
        if (this.tripulacionRepositorio.existsById(tripulacion.getCodigoTripulacion())) {
            return null;
        }else{
            return this.tripulacionRepositorio.save(tripulacion);
        }

    }
    public Tripulacion asociarTripulacionVuelo(long codigoVuelo, Tripulacion tripulacion) {
    Optional<Vuelo> vueloOpt = vueloRepositorio.findById(codigoVuelo);
    
    if (vueloOpt.isPresent()) {
        Vuelo vuelo = vueloOpt.get();
        
        // Asignar la tripulación al vuelo
        vuelo.setTripulacion(tripulacion);

        // Opcional: Agregar el vuelo a la lista de vuelos de la tripulación
        if (tripulacion.getVuelos() == null) {
            tripulacion.setVuelos(new ArrayList<>());
        }
        tripulacion.getVuelos().add(vuelo);
        
        // Guardar la tripulación (si es necesario, dependiendo de la lógica de negocio)
        tripulacionRepositorio.save(tripulacion);

        // Retornar la tripulación asociada
        return tripulacion;
    } else {
        throw new RuntimeException("Vuelo no encontrado con código: " + codigoVuelo);
    }
}


}
