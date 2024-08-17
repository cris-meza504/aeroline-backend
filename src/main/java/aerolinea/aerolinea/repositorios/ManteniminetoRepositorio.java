package aerolinea.aerolinea.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aerolinea.aerolinea.modelos.Mantenimiento;

@Repository
public interface ManteniminetoRepositorio extends JpaRepository<Mantenimiento,Long>{
    
}
