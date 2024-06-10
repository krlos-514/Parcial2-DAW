/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appweb.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author krlos
 */
@Entity
@Table(name = "inscripcion")
public class Inscripcion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripcion_id_seq")
    @SequenceGenerator(name = "inscripcion_id_seq", sequenceName = "inscripcion_id_seq", allocationSize = 1)
    
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "idAlumno")
    private Integer idAlumno;
    
    @Column(name = "idMateria")
    private Integer idMateria;
    
    @Column(name = "ciclo")
    private Integer ciclo;
    
    @Column(name = "anio")
    private String anio;
    
    @Column(name = "fechaInscripcion")
    private String fechaInscripcion;
    
    //-------------------------Getters & Setters-------------------------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    
    //-------------------------Equals & Hashcode-------------------------

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        return Objects.equals(this.id, other.id);
    }
    
    //-------------------------toString-------------------------

    @Override
    public String toString() {
        return "Inscripcion{" + "id=" + id + ", idAlumno=" + idAlumno + ", idMateria=" + idMateria + ", ciclo=" + ciclo + ", anio=" + anio + ", fechaInscripcion=" + fechaInscripcion + '}';
    }
    
    //-------------------------Constructores-------------------------

    public Inscripcion(Integer id) {
        this.id = id;
        Date current = new Date();
        String fechaInscrip = current.getDay()+"/"+current.getMonth()+"/"+current.getYear();
        this.fechaInscripcion = fechaInscrip;
    }

    public Inscripcion(Integer id, Integer idAlumno, Integer idMateria, Integer ciclo, String anio){
        this.id = id;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.ciclo = ciclo;
        this.anio = anio;
        
        Date current = new Date();
        String fechaInscrip = current.getDay()+"/"+current.getMonth()+"/"+current.getYear();
        this.fechaInscripcion = fechaInscrip;
    }
    
    public Inscripcion(Integer id, Integer idAlumno, Integer idMateria){
        this.id = id;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        Date current = new Date();
        String fechaInscrip = current.getDay()+"/"+current.getMonth()+"/"+current.getYear();
        this.fechaInscripcion = fechaInscrip;
    }
    
    public Inscripcion(){
        Date current = new Date();
        String fechaInscrip = current.getDay()+"/"+current.getMonth()+"/"+current.getYear();
        this.fechaInscripcion = fechaInscrip;
    }
    
}
