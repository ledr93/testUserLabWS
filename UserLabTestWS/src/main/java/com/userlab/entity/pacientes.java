package com.userlab.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "pacientes")
public class pacientes {
    @Id
    private long id;
    private String nombre;
    private String apellido;
    private String correo;
    @Column(name = "telefono_movil")
    private String telefonomovil;
    @Column(name = "telefono_fijo")
    private String telefonofijo;
    @Column(name = "DPI")
    private long dpi;

}
