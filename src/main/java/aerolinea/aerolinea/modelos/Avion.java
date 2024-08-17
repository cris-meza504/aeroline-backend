package aerolinea.aerolinea.modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "aviones")
public class Avion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoavion")
    private long codigoAvion;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "matricula", unique = true)
    private String matricula;

    @Column(name = "capacidad")
    private Integer capacidad;

    @OneToMany(mappedBy = "avion", cascade = CascadeType.ALL)
    private List<Mantenimiento> mantenimientos;

    @OneToMany(mappedBy = "avion", cascade = CascadeType.ALL)
    private List<Vuelo> vuelos;

    @OneToMany(mappedBy = "avion",cascade = CascadeType.ALL)
    private List<Pasajero> pasajeros;

    @OneToMany(mappedBy = "avion", cascade = CascadeType.ALL)
    private List<Asiento> asientos;
}
