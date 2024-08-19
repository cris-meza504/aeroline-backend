package aerolinea.aerolinea.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aerolinea.aerolinea.modelos.Mantenimiento;
import aerolinea.aerolinea.repositorios.AvionRepositorio;
import aerolinea.aerolinea.repositorios.ManteniminetoRepositorio;

@Service
public class MantenimientoServicio {
    
    @Autowired
    private ManteniminetoRepositorio manteniminetoRepositorio;

    @Autowired
    private AvionRepositorio avionRepositorio;

    public List<Mantenimiento> obtenerMantenimientos(){
        return this.manteniminetoRepositorio.findAll();
    }

    public Mantenimiento asociarMantenimientoAvion(long codigoAvion, Mantenimiento mantenimiento){
        if(this.avionRepositorio.existsById(codigoAvion)){
            mantenimiento.setAvion(this.avionRepositorio.findById(codigoAvion).get());;
            return this.manteniminetoRepositorio.save(mantenimiento);
        }

        return null;
    }
    
}
