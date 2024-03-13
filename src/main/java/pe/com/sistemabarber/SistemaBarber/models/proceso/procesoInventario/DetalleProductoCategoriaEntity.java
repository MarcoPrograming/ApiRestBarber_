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
import pe.com.sistemabarber.SistemaBarber.models.gestion.gestionInventario.CategoriaProductoEntity;
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
@Entity(name = "DetalleProductoCategoriaEntity")
@Table(name = "detalleproductocategoria")
public class DetalleProductoCategoriaEntity implements Serializable{
        private static final long serialVersionUID = 1L;
            @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Column(name = "id_detalleprocat")

    private long id_detalle;
            
                @ManyToOne
    @JoinColumn(name = "id_prod", nullable = false)
    private ProductoEntity producto;
                             @ManyToOne
    @JoinColumn(name = "id_cat", nullable = false)
    private CategoriaProductoEntity categoria;
                             
                                  @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;
     
      @Column(name = "descripcion", length = 50, nullable = false)
    private String descripcion;
      
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fecha_creacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fecha_actualizacion;


                             
                             
                             
                             



}
