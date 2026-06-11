package com.politecnico.sistema_citas_medicas.repository;

import com.politecnico.sistema_citas_medicas.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository <Cita, Long>{
    List<Cita> findAllByPacienteDocumento(String documento);
    List<Cita> findAllByMedicoId(Long medicoId);
}
