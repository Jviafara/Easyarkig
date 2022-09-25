package com.TO;

import lombok.Data;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name="personas")
public class Personas implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonas;
    private String nombres;
    private String apellido;
    @Column(name= "tipdoc")
    private String tipDoc;
    @Column(name= "numdoc")
    private String numDoc;
    private String direccion;
    private String telefono;
    private String email;

}
