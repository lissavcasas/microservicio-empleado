package com.dismac.personaldismac.service;

import com.dismac.personaldismac.dtos.EmpleadoCreateDTO;
import com.dismac.personaldismac.dtos.EmpleadoDTO;
import com.dismac.personaldismac.dtos.EmpleadoUpdateDTO;
import com.dismac.personaldismac.mappers.EmpleadoMapper;
import com.dismac.personaldismac.model.Empleado;
import com.dismac.personaldismac.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl  implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoDTO> listarEmpleados() {
        return EmpleadoMapper.instancia.listaEmpleadoAListaEmpleadoDTO( empleadoRepository.findAll());
    }

    @Override
    public EmpleadoDTO obtenerEmpleadoPorID(long id) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        EmpleadoDTO empleadoDTO = null;
        if (empleadoOptional.isPresent()) {
            Empleado empleado = empleadoOptional.get();
            empleadoDTO = EmpleadoMapper.instancia.empleadoAEmpleadoDTO(empleado);
        }
        return empleadoDTO;
    }

    @Override
    public EmpleadoDTO registrarEmpleado(EmpleadoCreateDTO empleadoCreateDTO) {
        Empleado empleado=EmpleadoMapper.instancia.empleadoCreateDTOAEmpleado(empleadoCreateDTO);
        Empleado respuestaEntity=empleadoRepository.save(empleado);
        EmpleadoDTO respuestaDTO= EmpleadoMapper.instancia.empleadoAEmpleadoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public EmpleadoDTO actualizarEmpleado(EmpleadoUpdateDTO empleadoUpdateDTO) {
        Empleado empleado=EmpleadoMapper.instancia.empleadoUpdateDTOAEmpleado(empleadoUpdateDTO);
        Empleado respuestaEntity=empleadoRepository.save(empleado);
        EmpleadoDTO respuestaDTO= EmpleadoMapper.instancia.empleadoAEmpleadoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public String eliminarEmpleado(long id) {
        boolean empleadoExistente = empleadoRepository.existsById(id);
        String resultado = "";
        if (empleadoExistente) {
            empleadoRepository.deleteById(id);
            resultado = "Registro Eliminado";
        } else {
            resultado = "No se pudo realizar la eliminación";
        }
        return resultado;
    }
}
