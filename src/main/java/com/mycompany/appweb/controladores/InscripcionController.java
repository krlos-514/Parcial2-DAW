/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appweb.controladores;

import com.mycompany.appweb.entidades.Inscripcion;
import com.mycompany.appweb.negocio.DataService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krlos
 */
@Named
@RequestScoped
public class InscripcionController{
    List<Inscripcion> inscripcionesList = new ArrayList<>();
    
    private Inscripcion inscripcion = new Inscripcion();
    
    @EJB
    DataService servicio;
    
    @PostConstruct
    public void cargarInscripciones(){
        inscripcionesList = servicio.getInscripciones();
    }
    
    public void guardarInscripcion(){
        if(inscripcion.getId()!=null){
            servicio.editInscripcion(inscripcion);
        }
        else{
         servicio.saveInscripcion(inscripcion);   
        }
        inscripcion = new Inscripcion();
        cargarInscripciones();
    }
    
    public void llenarFormEditar(Inscripcion inscripcion){
        this.inscripcion.setId(inscripcion.getId());
        this.inscripcion.setIdAlumno(inscripcion.getIdAlumno());
        this.inscripcion.setIdMateria(inscripcion.getIdMateria());
        this.inscripcion.setCiclo(inscripcion.getCiclo());
        this.inscripcion.setAnio(inscripcion.getAnio());
        this.inscripcion.setFechaInscripcion(inscripcion.getFechaInscripcion());
    }
    
    public void eliminarInscripcion(Inscripcion inscripcion){
        servicio.deleteInscripcion(inscripcion);
        cargarInscripciones();
    }
    
    //-------------Getters y Setters-------------------
    public void setInscripcionesList(List<Inscripcion> inscripcionesList){
        this.inscripcionesList = inscripcionesList;
    }
    
    public List<Inscripcion> getInscripcionesList(){
        return inscripcionesList;
    }
    
    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }
}
