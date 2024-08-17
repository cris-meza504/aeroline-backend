package aerolinea.aerolinea.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aerolinea.aerolinea.modelos.Tripulacion;

@Repository
public interface TripulacionRepositorio extends JpaRepository<Tripulacion,Long>{
    
}
