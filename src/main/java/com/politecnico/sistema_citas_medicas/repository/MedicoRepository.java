package com.politecnico.sistema_citas_medicas.repository;


import com.politecnico.sistema_citas_medicas.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository <Medico, Long> {

}
