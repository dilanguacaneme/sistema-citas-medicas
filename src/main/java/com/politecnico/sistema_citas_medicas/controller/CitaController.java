package com.politecnico.sistema_citas_medicas.controller;

import com.politecnico.sistema_citas_medicas.entity.Cita;
import com.politecnico.sistema_citas_medicas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    //Crear cita
    @PostMapping("/registrar")
    public Cita crearCita (@RequestBody Cita cita){

        return citaService.guardarCita(cita);
    }
    //Buscar citas
    @GetMapping ("/obtener")
    public List<Cita> obtenerCitas (){

        return citaService.obtenerCitas();
    }
    //Buscar cita por id
    @GetMapping("/buscar/{id}")
    public Cita obtenerCitaPorId(@PathVariable Long id ){

        return citaService.obtenerCitaPorId(id);
    }
    //Buscar citas asociadas a un numero de documento
    @GetMapping("/buscar-por-documento/{documento}")
    public String obtenerCitaPorDocumento (@PathVariable String documento){
        return citaService.obtenerCitasPorDocumento(documento);
    }
    //Eliminar cita
    @DeleteMapping("/eliminar/{id}")
    public void eliminarCita (@PathVariable Long id){
        citaService.eliminarCita(id);
    }

    //Visualizar agenda medico
    @GetMapping("/visualizar-agenda/{id}")
    public String visualizarAgenda (@PathVariable Long id){
        return citaService.obtenerTodoPorMedico(id);
    }
    //Consultar pacientes por medico
    @GetMapping("/visualizar-pacientes/{id}")
    public String visualizarPacientes (@PathVariable Long id){
        return citaService.consultarPacientes(id);
    }
}
