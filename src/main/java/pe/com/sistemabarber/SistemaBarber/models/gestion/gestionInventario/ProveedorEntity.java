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
@JsonPropertyOrder({"id_proveedor", "nombre","direccion", "telefono","correo","tipodoc","estado","fecha_creacion","fecha_actualizacion"})

@Entity(name="ProveedorEntity")
@Table(name = "Proveedor")
public class ProveedorEntity extends BaseEntity implements Serializable{
            @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_proveedor")
   private Long codigo;
        

      @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;
           @Column(name = "direccion", length = 45, nullable = false)
    private String direccion;
           
        @Column(name = "telefono", length = 45, nullable = false)
    private int telefono;
            @Column(name = "correo", length = 60, nullable = false)
    private String correo;
            
    @Column(name = "tipodoc", length = 70, nullable = false)
    private String tipodoc;
    
    
      @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fecha_creacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fecha_actualizacion;

}
