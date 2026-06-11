package com.politecnico.sistema_citas_medicas.controller;


import com.politecnico.sistema_citas_medicas.entity.Medico;
import com.politecnico.sistema_citas_medicas.entity.Paciente;
import com.politecnico.sistema_citas_medicas.service.MedicoService;
import com.politecnico.sistema_citas_medicas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    //Crear medico
    @PostMapping("/registrar")
    public Medico crearMedico(@RequestBody Medico medico){

        return medicoService.guardarMedico(medico);
    }

    //Buscar todos los medicos
    @GetMapping("/obtener")
    public List<Medico> listarMedicos (){

        return medicoService.obtenerMedicos();
    }

    //Buscar medico por id
    @GetMapping("/buscar/{id}")
    public Medico obtenerMedicoPorId (@PathVariable Long id){

        return medicoService.obtenerMedicoPorId(id);
    }

    //Eliminar medico por id
    @DeleteMapping("/eliminar/{id}")
    public void eliminarMedicoPorId(@PathVariable  Long id){

        medicoService.eliminarMedico(id);
    }
}
