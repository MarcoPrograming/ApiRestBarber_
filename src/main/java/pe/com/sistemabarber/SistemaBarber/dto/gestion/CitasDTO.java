/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.sistemabarber.SistemaBarber.dto.gestion;

/**
 *
 * @author USUARIO
 */
 
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.sistemabarber.SistemaBarber.dto.base.BaseDTO;
import pe.com.sistemabarber.SistemaBarber.models.gestion.ClienteEntity;
import pe.com.sistemabarber.SistemaBarber.models.gestion.TipoCitasEntity;

import java.time.LocalDateTime;
import pe.com.sistemabarber.SistemaBarber.models.gestion.HorarioDisponibleEntity;

 
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"id_citas", "cod_tipo_citas","cod_cliente",   "id_horariodi", "fecha_cita", "fecha_registro", "estado"})
public class CitasDTO extends BaseDTO {
        private TipoCitasEntity tipoCitas;

    private ClienteEntity cliente;
    private HorarioDisponibleEntity horarioDisponible;
    private LocalDateTime fechaCita;
    private LocalDateTime fechaRegistro;
    private String estado;
}

