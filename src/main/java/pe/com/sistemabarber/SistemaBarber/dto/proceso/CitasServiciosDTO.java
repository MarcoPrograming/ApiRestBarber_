package pe.com.sistemabarber.SistemaBarber.dto.proceso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.sistemabarber.SistemaBarber.models.gestion.CitasEntity;
import pe.com.sistemabarber.SistemaBarber.models.gestion.ServicioEntity;

@SuperBuilder
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitasServiciosDTO {
    private Long idDetalle;
    private ServicioEntity servicio;
    private CitasEntity cita;
    private int duracion;
    private double total;
    private String comentarios;
    private String estado ; 
}
