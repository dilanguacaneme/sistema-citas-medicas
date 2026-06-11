package com.politecnico.sistema_citas_medicas.controller;


import com.politecnico.sistema_citas_medicas.entity.Paciente;
import com.politecnico.sistema_citas_medicas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    //Crear paciente
    @PostMapping("/registrar")
    public Paciente crearPaciente(@RequestBody Paciente paciente){

        return pacienteService.guardarPaciente(paciente);
    }
    //Buscar todos los pacientes
    @GetMapping ("/obtener")
    public List<Paciente> listarPacientes (){
        return pacienteService.obtenerPacientes();
    }
    //Buscar paciente por id
    @GetMapping("/buscar/{id}")
    public Paciente obtenerPacientePorId (@PathVariable Long id){
        return pacienteService.obtenerPacientePorId(id);
    }
    //Eliminar paciente por id
    @DeleteMapping("/eliminar/{id}")
    public void eliminarPacientePorId(@PathVariable  Long id){
        pacienteService.eliminarPaciente(id);
    }
    //Buscar paciente por documento
    @GetMapping("/buscar-por-documento/{documento}")
    public String obtenerPacientePorDocumento (@PathVariable  String documento){
        return pacienteService.obtenerPacientePorDocumento(documento);
    }
}
