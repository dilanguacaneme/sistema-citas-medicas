package com.politecnico.sistema_citas_medicas.repository;


import com.politecnico.sistema_citas_medicas.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Long>  {

    Paciente findByDocumento(String documento);

}
