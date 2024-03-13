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

@SuperBuilder
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"id_prod","img","nombre","precio", "cantidad","stock","estado","fecha_creacion","fecha_actualizacion"})

@Entity(name="ProductoEntity")
@Table(name = "producto")
public class ProductoEntity extends BaseEntity implements Serializable {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_prod")

   private Long codigo;
        
//            @ManyToOne(optional = false)
//    @JoinColumn(name="id_tipo")
//    private TipoProductoEntity tipoproducto;
  @Column(name = "img", length = 200, nullable = true)
    private String img;
      @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;
      
          @Column(name = "precio", nullable = false)
    private double precio;
         
  @Column(name = "cantidad", nullable = false)
    private int cantidad;
  
    @Column(name = "stock", nullable = false)
    private int stock;
    
        @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fecha_creacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fecha_actualizacion;


    
    
    

  
  


          

      
        
        
        

    
}
