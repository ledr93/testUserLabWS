package com.userlab.repository;

import com.userlab.entity.pacientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pacientesRepository extends JpaRepository<pacientes,Long> {

    pacientes findFirstByNombreAndApellidoAndCorreoAndTelefonofijoAndTelefonomovilAndDpi(
            String nombre,String apellido,String correo,String telefono,String celular,long dpi
    );

    pacientes findFirstById(long id);

}
