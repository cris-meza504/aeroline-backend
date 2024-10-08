package aerolinea.aerolinea.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vuelos")
@Data
public class Vuelo {
    
    @Id
    @Column(name = "codigovuelo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoVuelo; 

    @Column(name = "numerovuelo")
    private String numeroVuelo;

    @Column(name = "estadovuelo")
    private String estadoVuelo;

    @Column(name = "horasalida")
    private LocalTime horaSalida;

    @Column(name = "horallegada")
    private LocalTime horaLlegada;

    @Column(name = "fechasalida")
    private LocalDate fechaSalida;

    @Column(name = "fechallegada")
    private LocalDate fechaLlegada;

    @Column(name = "origen")
    private String ciudadOrigen;

    @Column(name = "destino")
    private String ciudadDestino;


    @ManyToOne()
    @JoinColumn(name = "codigotripulacion",referencedColumnName = "codigotripulacion")
    private Tripulacion tripulacion;

    @ManyToOne()
    @JoinColumn(name = "codigoavion",referencedColumnName = "codigoavion")
    private Avion avion;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name="vuelo_pasajero",
        joinColumns = @JoinColumn(name="codigovuelo"),
        inverseJoinColumns = @JoinColumn(name="codigopasajero")
    )
    private List<Pasajero> pasajeros;

    @ManyToOne()
    @JoinColumn(name = "codigociudadorigen",referencedColumnName = "codigociudad")
    private Ciudad Origen;

    @ManyToOne()
    @JoinColumn(name = "codigociudaddestino",referencedColumnName = "codigociudad")
    private Ciudad Destino;


    
    


}
