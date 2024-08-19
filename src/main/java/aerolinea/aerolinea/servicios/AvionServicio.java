package aerolinea.aerolinea.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolinea.aerolinea.modelos.Avion;
import aerolinea.aerolinea.modelos.Mantenimiento;
import aerolinea.aerolinea.repositorios.AvionRepositorio;

@Service
public class AvionServicio {
    
    @Autowired
    private AvionRepositorio avionRepositorio;

    public List<Avion> obtnerAviones(){
       return this.avionRepositorio.findAll();
    }

    public Avion crearAvion(Avion avion){
        return this.avionRepositorio.save(avion);
    }

    public Avion obtenerAvionporid(Long codigo){
        if (this.avionRepositorio.existsById(codigo)) {
            return this.avionRepositorio.findById(codigo).get();
        }else{
            return null;
        }
    }

    public List<Mantenimiento> obtenerMantenimientosPorAvion(long codigoAvion){
        if (this.avionRepositorio.existsById(codigoAvion)) {
            return this.avionRepositorio.findById(codigoAvion).get().getMantenimientos();
        }else{
            return null;
        }
    }

}
