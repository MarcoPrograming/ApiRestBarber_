package pe.com.sistemabarber.SistemaBarber.models.gestion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.sistemabarber.SistemaBarber.models.base.BaseEntity;

/**
 *
 * @author ACER
 */
@SuperBuilder
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"id_horariodi", "fecha","nombre","hora_inicio", "hora_fin","estado","fecha_creacion"})

@Entity(name="HorarioDisponibleEntity")
@Table(name = "HorarioDisponible")
public class HorarioDisponibleEntity extends BaseEntity implements Serializable{
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_horariodi;
        
    
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    
    @Column(name = "nombre", length = 45, nullable = false)
    private String  nombre;

    @Column(name = "hora_inicio")
    private  Time hora_inicio;
    
    @Column(name = "hora_fin")
    private Time  hora_fin;
      @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fecha_creacion;

    
}
