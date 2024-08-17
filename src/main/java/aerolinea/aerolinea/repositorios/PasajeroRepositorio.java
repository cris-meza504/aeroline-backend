package aerolinea.aerolinea.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aerolinea.aerolinea.modelos.Pasajero;

@Repository
public interface PasajeroRepositorio extends JpaRepository<Pasajero,Long>{
    
}
