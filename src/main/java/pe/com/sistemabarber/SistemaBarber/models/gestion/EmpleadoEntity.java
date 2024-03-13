package pe.com.sistemabarber.SistemaBarber.models.gestion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import java.io.Serializable;
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
@JsonPropertyOrder({"id_empleado", "cargo","horario", "nombre","apellidos","tipoDoc",  "numDoc","edad",
"correo","telefono","direccion","estado","fecha_creacion","fecha_actualizacion"})
@Entity(name="EmpleadoEntity")
@Table(name="Empleado")
public class EmpleadoEntity   extends BaseEntity implements Serializable {
    private static final Long serialVersionUID = 1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_empleado")
    private Long codigo;
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="id_cargo")
    private CargoEntity cargo;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="id_horario")
    private HorarioEntity horario;

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 45, nullable = false)
    private String apellidos;

    @Column(name = "tipoDoc", length = 100, nullable = false)
    private String tipoDoc;
    
     @Column(name = "numDoc", length = 9, nullable = false)
    private String numDoc;
    

    private int edad;

    @Column(name = "correo", length = 100, nullable = false)
    @Email
    private String correo;

    @Column(name = "telefono", length = 9, nullable = false)
    private String telefono;

    @Column(name = "direccion", length = 45, nullable = false)
    private String direccion;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fecha_creacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fecha_actualizacion;

    

}
