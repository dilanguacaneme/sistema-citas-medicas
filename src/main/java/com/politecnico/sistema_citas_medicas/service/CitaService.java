package com.politecnico.sistema_citas_medicas.service;

import com.politecnico.sistema_citas_medicas.entity.Cita;
import com.politecnico.sistema_citas_medicas.entity.Paciente;
import com.politecnico.sistema_citas_medicas.repository.CitaRepository;
import com.politecnico.sistema_citas_medicas.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


@Service
@RequiredArgsConstructor
public class CitaService {
    @Autowired
    private final CitaRepository citaRepository;
    @Autowired
    private final PacienteService pacienteService;




    public List<Cita> obtenerCitas() {
        return citaRepository.findAll();
    }

    public Cita obtenerCitaPorId(Long id) {

        return citaRepository.findById(id).orElse(null);
    }

    public Cita guardarCita(Cita cita) {



        if (cita.getConfirmacion() == null) {
            cita.setConfirmacion("Por confirmar");
        }
        return citaRepository.save(cita);
    }

    public void eliminarCita(Long id) {
        if (citaRepository.existsById(id)){
            citaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Error: numero de cita no encontrado");
        }
    }

    public String obtenerCitasPorDocumento(String documento) {

        List <Cita> lstCitaPorDocumento = citaRepository.findAllByPacienteDocumento(documento);
        if (lstCitaPorDocumento.isEmpty()){
            return "Error: No hay citas asociadas a este numero de documento o no se ecuentra registrado";
        }else {
            String resultado = "";
            for (Cita cita : lstCitaPorDocumento) {
                LocalTime citaHora = cita.getHora();
                LocalDate citaFecha = cita.getFecha();
                String citaConfirmacion = cita.getConfirmacion();
                resultado += " Su cita esta estipulada para " +
                             " \n Dia: " + citaFecha +
                             " \n Hora: " + citaHora +
                             " \n Estado: " + citaConfirmacion+
                             "\n-----------------------------\n"   ;
            }
            return resultado;
        }
    }
    //Visualizar agenda
    public String obtenerTodoPorMedico (Long id){
        List <Cita> lstCitaPorMedico = citaRepository.findAllByMedicoId(id);
        if (lstCitaPorMedico.isEmpty()){
            return "No hay citas registradas para este medico";
        } else {

            String resultado ="";
            int contador = 1;

            for (Cita cita : lstCitaPorMedico){
                LocalTime citaHora = cita.getHora();
                LocalDate citaFecha = cita.getFecha();

                resultado += "\n Tiene citas para la siguientes fechas " +
                        "\n Cita # " + contador +
                        "\n Fecha: " + citaFecha +
                        "\n Hora : " + citaHora +
                        "\n-----------------------------\n";

                contador += 1;
            }
            return "El medico " + id + resultado;
        }
    }
    //Consultar pacientes
    public String consultarPacientes (Long id){
        List<Cita> lstPacientesPorMedico = citaRepository.findAllByMedicoId(id);

        if (lstPacientesPorMedico.isEmpty()){
            return "No hay pacientes asociados a este medico";
        } else {
            String resultado ="";
            int contador = 1;
            Set<Paciente> pacientesUnicos = new HashSet<>();
            for (Cita cita : lstPacientesPorMedico){
                pacientesUnicos.add(cita.getPaciente());
            }
            for (Paciente paciente : pacientesUnicos){
                String nombrePaciente = paciente.getNombre();
                String documentoPaciente = paciente.getDocumento();
                String telefonoPaciente = paciente.getTelefono();
                resultado += "\n Paciente #"+ contador +
                        "\n Nombre:" +nombrePaciente+
                        "\n Documento " +documentoPaciente+
                        "\n Telefono " +telefonoPaciente;
                contador +=1;
            }
            return resultado;
        }
    }
}
