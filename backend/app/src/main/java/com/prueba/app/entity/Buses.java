package com.prueba.app.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "buses")
public class Buses {
    @Id
    @Column(name = "id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "numeroBus", length = 50)
    private String numeroBus;

    @Column(name = "placa", length = 60)
    private String placa;

    @Column(name = "fecha_creacion", length = 12)
    private Date fecha_creacion;

    @Column(name = "caracteristicas", length = 50)
    private String caracteristicas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Marcas marca;

    @Column(name = "marca_id", length = 60)
    private int marca_id;

    @Column(name = "estado", length = 12)
    private String estado;

    public Buses(int id, String numeroBus, String placa, Date fecha_creacion, String caracteristicas,
            int marca_id, String estado) {
        this.id = id;
        this.numeroBus = numeroBus;
        this.placa = placa;
        this.fecha_creacion = fecha_creacion;
        this.caracteristicas = caracteristicas;
        this.marca_id = marca_id;
        this.estado = estado;
    }

    public Buses() {
    }

    public Buses(String numeroBus, String placa, Date fecha_creacion, String caracteristicas,
            int marca_id, String estado) {
        this.numeroBus = numeroBus;
        this.placa = placa;
        this.fecha_creacion = fecha_creacion;
        this.caracteristicas = caracteristicas;
        this.marca_id = marca_id;
        this.estado = estado;
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

    public Marcas getBusesmarcanombre() {
        return marca;
    }

    public void setBusesmarcanombre(Marcas marca) {
        this.marca = marca;
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