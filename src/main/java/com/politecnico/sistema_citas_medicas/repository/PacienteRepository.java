package com.politecnico.sistema_citas_medicas.repository;


import com.politecnico.sistema_citas_medicas.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Long>  {
}
