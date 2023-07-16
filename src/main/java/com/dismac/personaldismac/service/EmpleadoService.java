package com.dismac.personaldismac.service;

import com.dismac.personaldismac.dtos.EmpleadoCreateDTO;
import com.dismac.personaldismac.dtos.EmpleadoDTO;
import com.dismac.personaldismac.dtos.EmpleadoUpdateDTO;

import java.util.List;

public interface EmpleadoService {

    List<EmpleadoDTO> listarEmpleados();
    EmpleadoDTO obtenerEmpleadoPorID(long id);
    EmpleadoDTO registrarEmpleado(EmpleadoCreateDTO empleadoCreateDTO);
    EmpleadoDTO actualizarEmpleado(EmpleadoUpdateDTO empleadoUpdateDTO);
    String eliminarEmpleado(long id);
}
