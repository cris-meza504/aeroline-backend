package aerolinea.aerolinea.modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "ciudades")
@Data
public class Ciudad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigociudad")
    private long codigoCiudad;

    private String nombre;

    private String pais;

    @JsonIgnore
    @OneToMany(mappedBy = "ciudadOrigen",cascade = CascadeType.ALL)
    private List<Vuelo> vuelosOrigen;

    @JsonIgnore
    @OneToMany(mappedBy = "ciudadDestino",cascade = CascadeType.ALL)
    private List<Vuelo> vuelosDestino;


}
