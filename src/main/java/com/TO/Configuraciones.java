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
@Table(name="configuraciones")
public class Configuraciones  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConfiguraciones;
    @Column(name = "nombreparqueadero")
    private String nombreParqueadero;
    @Column(name = "valorhoracarro")
    private double valorHoraCarro;
    @Column(name = "valorhoramoto")
    private double valorHoraMoto;
    @Column(name = "valorfraccarro")
    private double valorFracCarro;
    @Column(name = "valorfracmoto")
    private double valorFracMoto;
    @Column(name = "valordiacarro")
    private double valorDiaCarro;
    @Column(name = "valordiamoto")
    private double valorDiaMoto;
    @Column(name = "valorsemcarro")
    private double valorSemCarro;
    @Column(name = "valorsemmoto")
    private double valorSemMoto;
    @Column(name = "valormescarro")
    private double valorMesCarro;
    @Column(name = "valormesmoto")
    private double valorMesMoto;

    
}
