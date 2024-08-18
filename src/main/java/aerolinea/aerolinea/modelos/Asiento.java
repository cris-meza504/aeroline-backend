package aerolinea.aerolinea.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "asientos")
public class Asiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoasiento")
    private long codigoAsiento;

    @Column(name = "numero_asiento")
    private String numero_asiento;

    @Column(name = "tipo_asiento")
    private String tipo_asiento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="codigoavion", referencedColumnName = "codigoavion")
    private Avion avion;

    @JsonIgnore
    @OneToOne(mappedBy = "asiento",cascade = CascadeType.ALL)
    private Pasajero pasajero;

}
