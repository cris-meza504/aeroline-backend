package aerolinea.aerolinea.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aerolinea.aerolinea.modelos.Ciudad;

@Repository
public interface CiudadRepositorio extends JpaRepository<Ciudad,Long>{
    
}
