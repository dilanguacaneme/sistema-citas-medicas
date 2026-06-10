package com.politecnico.sistema_citas_medicas.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Paciente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @Size(min = 3, max = 50)
    private String nombre;

    @NotBlank(message = "El documento no puede estar vacio")
    @Size(min = 3, max = 50)
    private String documento;

    @NotBlank
    @Size(min = 3, max = 50)
    private String telefono;

    @Email(message = "Debe ingresar un correo electrónico válido")
    @NotBlank(message = "El correo no puede estar vacío")
    @Size(min = 3, max = 50)
    private String correo;





}
