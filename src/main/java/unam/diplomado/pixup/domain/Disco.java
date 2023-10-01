package unam.diplomado.pixup.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.namespace.QName;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Disco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private Float precio;
    private Integer existencia;
    private Float decuento;
    @Column(name="fecha_lanzamiento")
    private Date fechaLanzamiento;
    private String imagen;
    @ManyToOne(targetEntity = Disquera.class)
    @JoinColumn(name = "id_disquera", nullable = false)
    private Disquera disquera;
    @ManyToOne(targetEntity = Artista.class)
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;
    @ManyToOne(targetEntity = GeneroMusical.class)
    @JoinColumn(name = "id_genero_musical", nullable = false)
    private GeneroMusical generoMusical;
}
