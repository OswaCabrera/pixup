package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    //cada municipio está asociado a un estado
    // municipio 1:1 estado, estado M:1 municipio
    @ManyToOne(targetEntity = Estado.class)
    @JoinColumn(name="id_estado", nullable = false)
    private Estado estado;
}
