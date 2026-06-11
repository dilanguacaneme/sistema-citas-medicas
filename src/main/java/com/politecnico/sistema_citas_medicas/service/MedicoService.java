package com.politecnico.sistema_citas_medicas.service;

import com.politecnico.sistema_citas_medicas.entity.Medico;
import com.politecnico.sistema_citas_medicas.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    @Autowired
    private final MedicoRepository medicoRepository;

    public List<Medico> obtenerMedicos() {

        return medicoRepository.findAll();
    }

    public Medico obtenerMedicoPorId(Long id) {

        if (medicoRepository.existsById(id)){
            return medicoRepository.findById(id).orElse(null);
        }else {
          throw new RuntimeException("Error: No existe medico con esta id");
        }
    }

    public Medico guardarMedico(Medico medico) {

        return medicoRepository.save(medico);
    }

    public void eliminarMedico(Long id) {

        if ((medicoRepository.existsById(id))){
            medicoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Error: Verifique que la id, este registrada a un medico");
        }

    }

}
