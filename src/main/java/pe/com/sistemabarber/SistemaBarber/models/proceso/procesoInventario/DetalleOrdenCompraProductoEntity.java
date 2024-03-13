
package pe.com.sistemabarber.SistemaBarber.models.proceso.procesoInventario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "DetalleOrdenCompraProductoEntity")
@Table(name = "detalleOrdenCompraProducto")
public class DetalleOrdenCompraProductoEntity implements Serializable {
    
        private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_detalleco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_detallepe;
        @ManyToOne
    @JoinColumn(name = "id_ordenco", nullable = false)
    private OrdenCompraEntity ordenpedido;
        
            @ManyToOne
    @JoinColumn(name = "id_prod", nullable = false)
    private ProductoEntity  producto;
            
                      @Column(name = "precio", nullable = false)
    private double precio;
         
  @Column(name = "cantidad", nullable = false)
    private int cantidad;
  
          @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fecha_creacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fecha_actualizacion;




}
