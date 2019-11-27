package com.userlab.json_request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class pacientesRequest {

    private String nombre;
    private String apellido;
    private String correo;
    private String celular;
    private String telefono;
    private long dpi;

}
