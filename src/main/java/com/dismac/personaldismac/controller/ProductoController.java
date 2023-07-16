package com.dismac.personaldismac.controller;

import com.dismac.personaldismac.dtos.EmpleadoCreateDTO;
import com.dismac.personaldismac.dtos.EmpleadoDTO;
import com.dismac.personaldismac.dtos.EmpleadoUpdateDTO;
import com.dismac.personaldismac.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("empleados")
    public ResponseEntity<List<EmpleadoDTO>> listarEmpleados(){
        return   new ResponseEntity<>(empleadoService.listarEmpleados(), HttpStatus.OK);
    }

    @GetMapping("/empleados/{empleadoId}")
    public ResponseEntity<EmpleadoDTO> obtenerEmpleadoPorId(@PathVariable("empleadoId") long empleadoId){
        return  new ResponseEntity<> ( empleadoService.obtenerEmpleadoPorID(empleadoId),HttpStatus.OK);
    }

    @PostMapping("empleados")
    public ResponseEntity<EmpleadoDTO> registrarEmpleado(@RequestBody EmpleadoCreateDTO empleadoCreateDTO){
        return  new ResponseEntity <>( empleadoService.registrarEmpleado(empleadoCreateDTO) ,HttpStatus.OK) ;
    }

    @PutMapping("empleados")
    public ResponseEntity<EmpleadoDTO> actualizarEmpleado(@RequestBody EmpleadoUpdateDTO empleadoUpdateDTO){
        return new ResponseEntity<>(empleadoService.actualizarEmpleado(empleadoUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/empleados/{empleadoId}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable("empleadoId") long empleadoId) {
        return new ResponseEntity<>( empleadoService.eliminarEmpleado(empleadoId),HttpStatus.OK);
    }

}
