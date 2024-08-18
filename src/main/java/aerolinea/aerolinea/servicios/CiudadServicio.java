package aerolinea.aerolinea.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolinea.aerolinea.repositorios.CiudadRepositorio;

@Service
public class CiudadServicio {
    
    @Autowired
    private CiudadRepositorio ciudadRepositorio;

    
}
