package pe.com.sistemabarber.SistemaBarber.dto.gestion.gestionInventario;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
@JsonPropertyOrder({"id_prod","img", "nombre","precio", "cantidad","stock","estado","fecha_creacion","fecha_actualizacion"})
public class ProductoDTO extends BaseDTO {
//        private TipoProductoEntity tipoproducto;
  private String img;
    private String nombre;
      
    private double precio;
         
    private int cantidad;
  
    private int stock;
        private String estado;
    
    private LocalDateTime fecha_creacion;

    private LocalDateTime fecha_actualizacion;



}
