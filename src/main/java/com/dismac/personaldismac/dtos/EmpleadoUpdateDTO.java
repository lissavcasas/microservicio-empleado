package com.dismac.personaldismac.dtos;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
public class EmpleadoUpdateDTO {
    private long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private BigDecimal salario;
    private Date fechaIngreso;
}
