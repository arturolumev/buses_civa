package com.prueba.app.DTO;

import java.util.Date;

public class BusesDTO {

    private int id;
    private String numeroBus;
    private String placa;
    private Date fecha_creacion;
    private String caracteristicas;
    private int marca_id;
    private String marcaNombre;
    private String estado;

    public BusesDTO(int id, String numeroBus, String placa, Date fecha_creacion, String caracteristicas,
            int marca_id, String marcaNombre, String estado) {
        this.id = id;
        this.numeroBus = numeroBus;
        this.placa = placa;
        this.fecha_creacion = fecha_creacion;
        this.caracteristicas = caracteristicas;
        this.marca_id = marca_id;
        this.marcaNombre = marcaNombre;
        this.estado = estado;
    }

    public BusesDTO() {
    }

    public int getBusesid() {
        return id;
    }

    public void setBusesid(int id) {
        this.id = id;
    }

    public String getBusesnumero() {
        return numeroBus;
    }

    public void setBusesnumero(String numeroBus) {
        this.numeroBus = numeroBus;
    }

    public String getBusesplaca() {
        return placa;
    }

    public void setBusesplaca(String placa) {
        this.placa = placa;
    }

    public Date getBusesfecha() {
        return fecha_creacion;
    }

    public void setBusesfecha(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getBusescaracteristicas() {
        return caracteristicas;
    }

    public void setBusescaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public int getBusesmarca() {
        return marca_id;
    }

    public void setBusesmarca(int marca_id) {
        this.marca_id = marca_id;
    }

    public String getBusesmarcanombre() {
        return marcaNombre;
    }

    public void setBusesmarcanombre(String marcaNombre) {
        this.marcaNombre = marcaNombre;
    }

    public String getBusesestado() {
        return estado;
    }

    public void setBusesestado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "BusesDTO{" +
                "id=" + id +
                ", numeroBus='" + numeroBus + '\'' +
                ", placa='" + placa + '\'' +
                ", fecha_creacion=" + fecha_creacion +
                ", caracteristicas='" + caracteristicas + '\'' +
                ", marca_id=" + marca_id +
                ", estado='" + estado + '\'' +
                '}';
    }
}