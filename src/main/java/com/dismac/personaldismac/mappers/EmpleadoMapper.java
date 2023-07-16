package com.dismac.personaldismac.mappers;

import com.dismac.personaldismac.dtos.EmpleadoCreateDTO;
import com.dismac.personaldismac.dtos.EmpleadoDTO;
import com.dismac.personaldismac.dtos.EmpleadoUpdateDTO;
import com.dismac.personaldismac.model.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmpleadoMapper {
    EmpleadoMapper instancia= Mappers.getMapper(EmpleadoMapper.class);

    EmpleadoDTO empleadoAEmpleadoDTO(Empleado empleado);
    Empleado empleadoDTOAEmpleado(EmpleadoDTO empleadoDTO);
    Empleado empleadoCreateDTOAEmpleado(EmpleadoCreateDTO empleadoCreateDTO);
    Empleado empleadoUpdateDTOAEmpleado(EmpleadoUpdateDTO empleadoUpdateDTO);
    List<EmpleadoDTO> listaEmpleadoAListaEmpleadoDTO (List<Empleado> listaEmpleado);

}
