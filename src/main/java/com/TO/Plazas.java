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
@Table(name="plazas")
public class Plazas  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlazas;
    @Column(name = "codigoplaza")
    private String codigoPlaza;
    @Column(name = "tipoplaza")
    private String tipoPlaza;
    private String estado;
}
