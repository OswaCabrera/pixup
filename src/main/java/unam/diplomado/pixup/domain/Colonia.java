package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

public class Colonia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String cp;
    // Colinias M:1 con Municipio,
    @ManyToOne(targetEntity = Municipio.class)
    @JoinColumn(name = "id_municipio", nullable = false)
    private Municipio municipio;
}
