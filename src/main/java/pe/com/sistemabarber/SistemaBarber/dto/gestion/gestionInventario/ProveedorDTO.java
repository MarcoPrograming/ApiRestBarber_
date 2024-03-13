package pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.sistemabarber.SistemaBarber.dto.base.BaseDTO;

/**
 *
 * @author ACER
 */
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"id_proveedor", "nombre", "direccion", "telefono", "correo", "tipodoc","estado", "fecha_creacion", "fecha_actualizacion"})
public class ProveedorDTO extends BaseDTO {

    private String nombre;
    private String direccion;
    private int telefono;
    private int correo;
    private String tipodoc;
        private String estado;

    private LocalDateTime fecha_creacion;
    private LocalDateTime fecha_actualizacion;

}
