/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appweb.resources;

import com.mycompany.appweb.entidades.Materia;
import com.mycompany.appweb.negocio.DataService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author krlos
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/materias")
public class RecursoMateria {
    
    @EJB DataService servicio;
    //--------------------------------------------------Materia--------------------------------------------------
    
    @GET
    public Response getMateria(){
        List<Materia> materia = servicio.getMaterias();
        
        return Response.ok(materia).build();
    }
    
    @POST
    public Response saveMateria(Materia materia){
        servicio.saveMateria(materia);
        
        return Response.ok("Materia creada exitosamente").build();
    }
    
    @PUT
    public Response editMateria(Materia materia){
        servicio.editMateria(materia);
        
        return Response.ok("Materia editada exitosamente").build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteMateria(@PathParam("id") Integer id){
        servicio.deleteMateria(new Materia(id));
        
        return Response.ok("Materia eliminada exitosamente").build();
    }
}
