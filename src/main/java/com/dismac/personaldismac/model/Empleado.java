package com.dismac.personaldismac.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tb_empleado")
@Getter
@Setter
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_empleado")
    private long id;

    @Column(name="nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name="ape_pat", length = 100, nullable = false)
    private String apellidoPaterno;

    @Column(name="ape_mat", length = 100, nullable = false)
    private String apellidoMaterno;

    @Column(name="direccion", length = 300, nullable = false)
    private String direccion;

    @Column(name="salario", scale = 2, nullable = false)
    private BigDecimal salario;

    @Column(name="fecha_ingreso",  nullable = false)
    @Temporal(value= TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIngreso;
}