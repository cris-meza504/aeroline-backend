package aerolinea.aerolinea.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolinea.aerolinea.modelos.Vuelo;
import aerolinea.aerolinea.repositorios.VueloRepositorio;

@Service
public class VueloServicio {
    
    @Autowired
    private VueloRepositorio vueloRepositorio;

    public List<Vuelo> obtenerVuelos(){
        return this.vueloRepositorio.findAll();
    }
}
