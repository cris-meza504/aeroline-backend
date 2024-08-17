package aerolinea.aerolinea.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aerolinea.aerolinea.modelos.Avion;

@Repository
public interface AvionRepositorio extends JpaRepository<Avion,Long>{
    
}
