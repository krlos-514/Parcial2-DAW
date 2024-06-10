/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appweb.controladores;

import com.mycompany.appweb.entidades.Materia;
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
public class MateriaController {
    List<Materia> materiasList = new ArrayList<>();
    
    private Materia materia = new Materia();
    
    @EJB
    DataService servicio;
    
    @PostConstruct
    public void cargarMaterias(){
        materiasList = servicio.getMaterias();
    }
    
    public void guardarMateria(){
        if(materia.getId()!=null){
            servicio.editMateria(materia);
        }
        else{
         servicio.saveMateria(materia);   
        }
        materia = new Materia();
        cargarMaterias();
    }
    
    public void llenarFormEditar(Materia materia){
        this.materia.setId(materia.getId());
        this.materia.setNombre(materia.getNombre());
        this.materia.setCodigo(materia.getCodigo());
    }
    
    public void eliminarMateria(Materia materia){
        servicio.deleteMateria(materia);
        cargarMaterias();
    }
    
    //-------------Getters y Setters-------------------
    public void setMateriasList(List<Materia> materiasList){
        this.materiasList = materiasList;
    }
    
    public List<Materia> getMateriasList(){
        return materiasList;
    }
    
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Materia getMateria() {
        return materia;
    }
}
