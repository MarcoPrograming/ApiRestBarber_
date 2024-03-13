
package pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.sistemabarber.SistemaBarber.models.base.BaseEntity;
import pe.com.sistemabarber.SistemaBarber.models.gestion.EmpleadoEntity;

@SuperBuilder
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"id_ordenco","id_empleado","id_proveedor", "titulo","fecha","total","estado",
"fecha_creacion","fecha_actualizacion"})
@Entity(name="OrdenCompraEntity")
@Table(name="orden_compra")
public class OrdenCompraEntity extends BaseEntity implements Serializable {
        private static final Long serialVersionUID = 1L; 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_ordenco")
    private Long codigo;
    
        @ManyToOne(optional = false)
    @JoinColumn(name="id_empleado")
    private EmpleadoEntity empleado;
        
           @ManyToOne(optional = false)
    @JoinColumn(name="id_proveedor")
    private ProveedorEntity proveedor;
    
 @Column(name = "titulo", length = 45, nullable = false)
    private String titulo;
 
  @Column(name = "fecha", nullable = false)
    private Date fecha;
  
    @Column(name = "total", nullable = false)
    private Double total;
    
       @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fecha_creacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fecha_actualizacion;

    
    




}
