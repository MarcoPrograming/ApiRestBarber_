package pe.com.sistemabarber.SistemaBarber.models.gestion;

import pe.com.sistemabarber.SistemaBarber.models.proceso.DetalleCitasServiciosEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"id_citas", "cod_tipo_citas", "cod_cliente", "id_horariodi","fecha_cita", "fecha_registro", "estado"})
@Entity(name = "CitasEntity")
@Table(name = "citas")
public class CitasEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_citas")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_tipo_citas")
    private TipoCitasEntity tipoCitas;

    @ManyToOne
    @JoinColumn(name = "cod_cliente")
    private ClienteEntity cliente;

        @ManyToOne
    @JoinColumn(name = "id_horariodi")
    private HorarioDisponibleEntity horarioDisponible;

    @JsonIgnore
    @OneToMany(mappedBy = "cita", cascade = CascadeType.ALL)
    private List<DetalleCitasServiciosEntity> citaServicios;

    @Column(name = "fecha_cita", nullable = false)
    private LocalDateTime fechaCita;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "estado", nullable = false)
    private String estado;

    
}
