package unam.diplomado.pixup.domain;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    @ManyToOne(targetEntity = Disco.class)
    @JoinColumn(name="id_disco",nullable = false)
    private Disco disco;

    @JsonbDateFormat("HH:mm:ss")
    @Column(name="duracion")
    @Temporal(TemporalType.TIME)
    private java.time.LocalTime duracion;

}
