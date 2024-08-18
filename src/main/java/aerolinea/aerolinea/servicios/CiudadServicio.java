package aerolinea.aerolinea.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolinea.aerolinea.modelos.Ciudad;
import aerolinea.aerolinea.repositorios.CiudadRepositorio;

@Service
public class CiudadServicio {
    
    @Autowired
    private CiudadRepositorio ciudadRepositorio;

    public List<Ciudad> ObtenerCiudad(){
       return this.ciudadRepositorio.findAll();
    }
}
