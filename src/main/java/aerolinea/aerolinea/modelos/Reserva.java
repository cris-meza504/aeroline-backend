package aerolinea.aerolinea.modelos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "reservas")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoreserva")
    private long codigoReserva;

    @Column(name = "fechareserva")
    private LocalDateTime fechaReserva;

    @Column(name = "numeroreserva",unique = true)
    private String numeroReserva;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "codigopasajero",referencedColumnName = "codigopasajero")
    private Pasajero pasajero;
}
