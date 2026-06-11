package com.politecnico.sistema_citas_medicas.service;

import com.politecnico.sistema_citas_medicas.entity.Cita;
import com.politecnico.sistema_citas_medicas.entity.Paciente;
import com.politecnico.sistema_citas_medicas.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteService  {

    @Autowired
    private final PacienteRepository pacienteRepository;


    public List<Paciente> obtenerPacientes() {

        return pacienteRepository.findAll();
    }

    public Paciente obtenerPacientePorId(Long id) {

        return pacienteRepository.findById(id).orElse(null);
    }

    public String obtenerPacientePorDocumento (String documento){

        Paciente paciente = pacienteRepository.findByDocumento(documento);

        //paciente 1000320709
        if (paciente == null){
            throw new IllegalArgumentException("Error: No existe un paciente con ese documento" + documento);
        }
        return "Datos del paciente " + paciente;
    }

    public Paciente guardarPaciente(Paciente paciente) {

        Paciente pacienteExistente = pacienteRepository.findByDocumento(paciente.getDocumento());

        if (pacienteExistente != null){

            throw new IllegalArgumentException("Error: Ya existe un cliente registrado con el documento " + pacienteExistente.getDocumento());
        } else {

            return pacienteRepository.save(paciente);
        }
    }

    public void eliminarPaciente(Long id) {

        if (pacienteRepository.existsById(id)){
            pacienteRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No existe un paciente con ese id " + id);
        }
    }
}
