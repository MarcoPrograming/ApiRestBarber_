
package pe.com.sistemabarber.SistemaBarber.dto.proceso.procesoInventario;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.OrdenCompraEntity;
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
public class DetalleOrdenCompraProductoDTO {
    
        private OrdenCompraEntity ordencompra;
        
    private ProductoEntity  producto;
            
    private double precio;
         
    private int cantidad;
  
    private LocalDateTime fecha_creacion;

    private LocalDateTime fecha_actualizacion;

}
