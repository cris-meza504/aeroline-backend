package aerolinea.aerolinea.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aerolinea.aerolinea.modelos.Asiento;

@Repository
public interface AsientoRepositorio extends JpaRepository<Asiento,Long>{
    
}
