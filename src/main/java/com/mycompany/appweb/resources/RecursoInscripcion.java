/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appweb.resources;

import com.mycompany.appweb.entidades.Inscripcion;
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
@Path("/inscripcion")
public class RecursoInscripcion {
    @EJB DataService servicio;
    
    @GET
    public Response getInscripcion(){
        List<Inscripcion> inscripcion = servicio.getInscripciones();
        
        return Response.ok(inscripcion).build();
    }
    
    @POST
    public Response saveInscripcion(Inscripcion inscripcion){
        servicio.saveInscripcion(inscripcion);
        
        return Response.ok("Inscripcion creada exitosamente").build();
    }
    
    @PUT
    public Response editInscripcion(Inscripcion inscripcion){
        servicio.editInscripcion(inscripcion);
        
        return Response.ok("Inscripcion editada exitosamente").build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteInscripcion(@PathParam("id") Integer id){
        servicio.deleteInscripcion(new Inscripcion(id));
        
        return Response.ok("Inscripcion eliminada exitosamente").build();
    }
}
