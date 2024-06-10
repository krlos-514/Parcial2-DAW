/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appweb.negocio;

import com.mycompany.appweb.entidades.Alumno;
import com.mycompany.appweb.entidades.Inscripcion;
import com.mycompany.appweb.entidades.Materia;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author krlos
 */
@Stateless
public class DataService {
    
    @PersistenceContext( unitName = "pu")
    EntityManager entityManager;
    
    //--------------------------------------------------Alumno--------------------------------------------------
    
    public List<Alumno> getAlumnos(){
        Query query = entityManager.createQuery("SELECT e FROM Alumno e ORDER BY e.id ASC");
        
        List<Alumno> alumnos = query.getResultList();
        
        return alumnos;
    }
    
    @Transactional
    public void saveAlumno(Alumno alumno){
        entityManager.persist(alumno);
    }
    
    @Transactional
    public void deleteAlumno(Alumno alumno){
        Alumno alumnoEliminar = entityManager.find(Alumno.class, alumno.getId());
        
        entityManager.remove(alumnoEliminar);
    }
    
    @Transactional
    public void editAlumno(Alumno alumno){
        entityManager.merge(alumno);
    }
    
    //--------------------------------------------------Materia--------------------------------------------------
    
    public List<Materia> getMaterias(){
        Query query = entityManager.createQuery("SELECT e FROM Materia e ORDER BY e.id ASC");
        
        List<Materia> materias = query.getResultList();
        
        return materias;
    }
    
    @Transactional
    public void saveMateria(Materia materia){
        entityManager.persist(materia);
    }
    
    @Transactional
    public void deleteMateria(Materia materia){
        Materia materiaEliminar = entityManager.find(Materia.class, materia.getId());
        
        entityManager.remove(materiaEliminar);
    }
    
    @Transactional
    public void editMateria(Materia materia){
        entityManager.merge(materia);
    }
    
    //--------------------------------------------------Inscripcion--------------------------------------------------
    
    public List<Inscripcion> getInscripciones(){
        Query query = entityManager.createQuery("SELECT e FROM Inscripcion e ORDER BY e.id ASC");
        
        List<Inscripcion> inscripciones = query.getResultList();
        
        return inscripciones;
    }
    
    @Transactional
    public void saveInscripcion(Inscripcion inscripcion){
        entityManager.persist(inscripcion);
    }
    
    @Transactional
    public void deleteInscripcion(Inscripcion inscripcion){
        Inscripcion inscripcionEliminar = entityManager.find(Inscripcion.class, inscripcion.getId());
        
        entityManager.remove(inscripcionEliminar);
    }
    
    @Transactional
    public void editInscripcion(Inscripcion inscripcion){
        entityManager.merge(inscripcion);
    }
}
