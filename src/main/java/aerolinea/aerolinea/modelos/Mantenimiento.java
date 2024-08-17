package aerolinea.aerolinea.modelos;

import java.time.LocalDate;

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
@Table(name = "mantenimientos")
public class Mantenimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigomantenimiento")
    private long codigoMantenimineto;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "descripcion")
    private String descripcion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="codigoavion", referencedColumnName = "codigoavion")
    private Avion avion;
}
