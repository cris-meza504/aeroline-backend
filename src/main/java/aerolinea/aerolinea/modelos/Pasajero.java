package aerolinea.aerolinea.modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "pasajeros")
public class Pasajero {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigopasajero")
    private long codigoPasajero;

    private String nombre;

    private String apellido;

    private String correo;

    @Column(name = "contraseña")
    private String contranna;

    private String telefono;

    @Column(name = "documentoidentidad",unique = true)
    private String documentoIdentidad;

    @JsonIgnore
    @ManyToMany(mappedBy="pasajeros")
    private List<Vuelo> vuelos;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "codigoavion", referencedColumnName = "codigoavion")
    private Avion avion;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="codigoasiento", referencedColumnName = "codigoasiento")
    private Asiento asiento;

    @OneToMany(mappedBy = "pasajero",cascade = CascadeType.ALL)
    private List<Reserva> reservas;
}
