package aerolinea.aerolinea.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aerolinea.aerolinea.modelos.Vuelo;

@Repository
public interface VueloRepositorio extends JpaRepository<Vuelo,Long>{
    
}
