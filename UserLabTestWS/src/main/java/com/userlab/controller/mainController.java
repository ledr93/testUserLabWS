/*luis de leon*/
package com.userlab.controller;

import com.userlab.entity.pacientes;
import com.userlab.json_request.editPacientesRequest;
import com.userlab.json_request.pacientesRequest;
import com.userlab.json_response.pacienteAddResponse;
import com.userlab.json_response.pacientesResponse;
import com.userlab.repository.pacientesRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@RestController
public class mainController {

    private final pacientesRepository pacientesRepository;


    public mainController(com.userlab.repository.pacientesRepository pacientesRepository) {
        this.pacientesRepository = pacientesRepository;
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @GetMapping("/getPacientes")

    public pacientesResponse getPacientes(HttpServletRequest request) {

        return new pacientesResponse(pacientesRepository.findAll());
    }


    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping("/addPacientes")
    public pacienteAddResponse getPacientes(@RequestBody pacientesRequest request) {

        //verifica existencia del paciente
        pacientes data;
        data = pacientesRepository.findFirstByNombreAndApellidoAndCorreoAndTelefonofijoAndTelefonomovilAndDpi(
                request.getNombre(),
                request.getApellido(),
                request.getCorreo(),
                request.getTelefono(),
                request.getCelular(),
                request.getDpi()
        );

        if (data != null){
            pacienteAddResponse response = new pacienteAddResponse();
            response.setRespuesta("paciente ya existe..");
            return response;
        }

        /*crea un nuevo paciente*/
        pacientes newData = new pacientes();
        newData.setNombre(request.getNombre());
        newData.setApellido(request.getApellido());
        newData.setCorreo(request.getCorreo());
        newData.setTelefonofijo(request.getTelefono());
        newData.setTelefonomovil(request.getCelular());
        newData.setDpi(request.getDpi());

        pacientesRepository.save(newData);

        pacienteAddResponse response = new pacienteAddResponse();
        response.setRespuesta("paciente agregado correctamente..");
        return response;
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping("/editPacientes")
    public pacienteAddResponse editPacientes(@RequestBody editPacientesRequest request) {

        pacientes data;
        data = pacientesRepository.findFirstById(
                request.getId()
        );

        if (data == null){
            pacienteAddResponse response = new pacienteAddResponse();
            response.setRespuesta("paciente no existe");
            return response;
        }

        data.setNombre(request.getNombre());
        data.setApellido(request.getApellido());
        data.setCorreo(request.getCorreo());
        data.setTelefonofijo(request.getTelefono());
        data.setTelefonomovil(request.getCelular());
        data.setDpi(request.getDpi());
        pacientesRepository.save(data);

        pacienteAddResponse response = new pacienteAddResponse();
        response.setRespuesta("paciente editado correctamente");
        return response;
    }

}
