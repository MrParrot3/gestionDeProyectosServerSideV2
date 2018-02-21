/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxServerSide.rest;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxServerSide.entity.Proyecto;
import javafxServerSide.exception.ConsultaProyectoException;
import javafxServerSide.exception.DeleteProyectoException;
import javafxServerSide.exception.EditProyectoException;
import javafxServerSide.exception.NewProyectoException;
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
import javafxServerSide.ejb.ProyectoEJBLocal;

/**
 *
 * @author Iker Jon Mediavilla
 */

@Path("proyecto")
public class ProyectoREST {
    
     private static final Logger logger = Logger.getLogger("javafxServerSide");
    
    @EJB
    private ProyectoEJBLocal ejb;
    
    /**
     * create a new project
     * @param proyecto 
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Proyecto proyecto) {
        try{
            logger.log(Level.INFO,"ProyectoREST: Create {0}.", proyecto);
            ejb.newProyecto(proyecto);
        }catch (NewProyectoException e){
            logger.log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * edit the project
     * @param proyecto 
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Proyecto proyecto) {
        try{
            logger.log(Level.INFO, "ProyectoRest: Edit {0}.", proyecto);
            ejb.editProyecto(proyecto);
        }catch(EditProyectoException e){
            logger.log(Level.SEVERE, null, e);
        }
    }

    /**
     * delete the project finding by id
     * @param id
     * @throws DeleteProyectoException 
     */
    @DELETE
    @Path("{id}")
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") Integer id) throws DeleteProyectoException {
        try{
            logger.log(Level.INFO, "ProyectoRest: Delete proyecto by id={0}.", id);
            ejb.deleteProyecto(ejb.findProyectoById(id));
        }catch(ConsultaProyectoException | DeleteProyectoException e){
            logger.log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * find the project by id
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Proyecto find(@PathParam("id") Integer id) {
        Proyecto proyecto=null;
        try{
            logger.log(Level.INFO,"ProyectoRest: Find proyecto by id={0}.",id);
            proyecto=ejb.findProyectoById(id);
        }catch(ConsultaProyectoException e){
            logger.log(Level.SEVERE, null, e);
        }
        return proyecto;
    }
    
    /**
     * find all projects
     * @return Collection<Proyecto>
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Proyecto> findAll() {
        Collection<Proyecto> proyectos = null;
        try{
            logger.log(Level.INFO,"ProyectoRest: Find all proyectos.");
            proyectos=ejb.getAllProyectos();
        }catch(ConsultaProyectoException e){
            logger.log(Level.SEVERE, null, e);
        }
        return proyectos;
    }
    
    /**
     * parameterized queries to find project
     * @param tipo
     * @param nif
     * @return Collection<Proyecto>
     */
    @GET
    @Path("find/{tipo}/{nif}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Proyecto> findProyectosFiltrados(@PathParam("tipo") Integer tipo, @PathParam("nif") String nif) {
        Collection<Proyecto> proyectos = null;
        try{
            logger.log(Level.INFO,"ProyectoRest: Find proyectos filter.");
            proyectos=ejb.getProyectosFiltrados(tipo, nif);
        }catch(ConsultaProyectoException e){
            logger.log(Level.SEVERE, null, e);
        }
        return proyectos;
    }

    
    
    
}
