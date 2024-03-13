package pe.com.sistemabarber.SistemaBarber.dto.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author ACER
 */

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO {

    @Builder.Default
    private Long codigo=0L;
}
