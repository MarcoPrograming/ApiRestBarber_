package pe.com.sistemabarber.SistemaBarber.models.proceso;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.sistemabarber.SistemaBarber.models.base.BaseEntity;
import pe.com.sistemabarber.SistemaBarber.models.gestion.CitasEntity;
import pe.com.sistemabarber.SistemaBarber.models.gestion.ServicioEntity;


@Entity(name = "CitasServiciosEntity")
@Table(name = "Detalle_Citas_servicios")
@SuperBuilder
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DetalleCitasServiciosEntity implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long idDetalle;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_servicio")
    private ServicioEntity servicio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_citas")
    private CitasEntity cita;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name = "comentarios")
    private String comentarios;

}
