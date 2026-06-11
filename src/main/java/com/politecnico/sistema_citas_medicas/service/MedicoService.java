package com.politecnico.sistema_citas_medicas.service;

import com.politecnico.sistema_citas_medicas.entity.Medico;
import com.politecnico.sistema_citas_medicas.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicoService {

    @Autowired
    private final MedicoRepository medicoRepitory;

    public List<Medico> obtenerMedicos() {

        return medicoRepitory.findAll();
    }

    public Medico obtenerMedicoPorId(Long id) {

        if (medicoRepitory.existsById(id)){
            return medicoRepitory.findById(id).orElse(null);
        }else {
          throw new RuntimeException("Error: No existe medico con esta id");
        }
    }

    public Medico guardarMedico(Medico medico) {

        return medicoRepitory.save(medico);
    }

    public void eliminarMedico(Long id) {

        if ((medicoRepitory.existsById(id))){
            medicoRepitory.deleteById(id);
        } else {
            throw new RuntimeException("Error: Verifique que la id, este registrada a un medico");
        }

    }
}
