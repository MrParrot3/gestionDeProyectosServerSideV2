/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxServerSide.rest;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javafxServerSide.ejb.ServicioEJBLocal;
import javafxServerSide.entity.Servicio;
import javafxServerSide.exception.ConsultaServicioException;
import javafxServerSide.exception.DeleteServicioException;
import javafxServerSide.exception.EditServicioException;
import javafxServerSide.exception.NewServicioException;

/**
 *
 * @author Iker Jon Mediavilla
 */

@Path("servicio")
public class ServicioREST {
    
     private static final Logger logger = Logger.getLogger("javafxServerSide");
    
    @EJB
    private ServicioEJBLocal ejb;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Servicio servicio) {
        try{
            logger.log(Level.INFO,"ServicioREST: Create {0}.", servicio);
            ejb.newServicio(servicio);
        }catch (NewServicioException e){
            logger.log(Level.SEVERE, null, e);
        }
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Servicio servicio) {
        try{
            logger.log(Level.INFO, "ServicioRest: Edit {0}.", servicio);
            ejb.editServicio(servicio);
        }catch(EditServicioException e){
            logger.log(Level.SEVERE, null, e);
        }
    }
    
     @DELETE
    @Path("{id}")
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") Integer id) throws DeleteServicioException {
        try{
            logger.log(Level.INFO, "ServicioRest: Delete servicio by id={0}.", id);
            ejb.deleteServicio(ejb.findServicioById(id));
        }catch(ConsultaServicioException | DeleteServicioException e){
            logger.log(Level.SEVERE, null, e);
        }
    }
    
     @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Servicio find(@PathParam("id") Integer id) {
       Servicio servicio=null;
        try{
            logger.log(Level.INFO,"ServicioRest: Find servicio by id={0}.",id);
            servicio=ejb.findServicioById(id);
        }catch(ConsultaServicioException e){
            logger.log(Level.SEVERE, null, e);
        }
        return servicio;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Servicio> findAll() {
        Collection<Servicio> servicios = null;
        try{
            logger.log(Level.INFO,"ServicioRest: Find all servicios.");
            servicios=ejb.getAllServicios();
        }catch(ConsultaServicioException e){
            logger.log(Level.SEVERE, null, e);
        }
        return servicios;
    }
    
    @GET
    @Path("find/{tipo}/{id}/{nombre}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Servicio> findServiciosFiltrados(@PathParam("tipo") Integer tipo, @PathParam("id") Integer id, @PathParam("nombre") String nombre) {
        Collection<Servicio> servicios = null;
        try{
            logger.log(Level.INFO,"ServicioRest: Find servicios filter.");
            servicios=ejb.getServiciosFiltrados(tipo, id, nombre);
        }catch(ConsultaServicioException e){
            logger.log(Level.SEVERE, null, e);
        }
        return servicios;
    }
}
