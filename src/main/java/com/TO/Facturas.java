package com.TO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "facturas")
public class Facturas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFacturas;

    @Column(name = "codigofactura")
    private int codigoFactura;

    private String placa;
    private Double valor;

    @Column(name = "plazaasociada")
    private String plazaAsociada;

    @Column(name = "tipocontrato")
    private String tipoContrato;

    @Column(name = "fechaentrada")
    private Date fechaEntrada;

    @Column(name = "fechasalida")
    private Date fechaSalida;

    @Column(name = "fechafactura")
    private Date fechaFactura = new Date();

    private int idPersonas;
    private int idPlazas;

}
