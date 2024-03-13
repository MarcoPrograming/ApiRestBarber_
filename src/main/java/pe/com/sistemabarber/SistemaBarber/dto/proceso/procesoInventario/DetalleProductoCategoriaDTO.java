
package pe.com.sistemabarber.SistemaBarber.dto.proceso.procesoInventario;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.CategoriaProductoEntity;
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.ProductoEntity;

/**
 *
 * @author ACER
 */
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DetalleProductoCategoriaDTO {
       private ProductoEntity producto;
    private CategoriaProductoEntity categoria;
                             
    private String nombre;
     
    private String descripcion;
      
    private LocalDateTime fecha_creacion;

    private LocalDateTime fecha_actualizacion;
}
