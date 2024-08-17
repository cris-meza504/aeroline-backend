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
@Table(name = "tripulacion")
public class Tripulacion {
    
    @Id
    @Column(name = "codigotripulacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoTripulacion;

    private String nombre;

    private String rol;

    @OneToMany(mappedBy = "tripulacion",cascade = CascadeType.ALL)
    private List<Vuelo> vuelos;

}
