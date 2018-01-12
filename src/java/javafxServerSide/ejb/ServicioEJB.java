/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxServerSide.ejb;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxServerSide.entity.Servicio;
import javafxServerSide.exception.ConsultaServicioException;
import javafxServerSide.exception.DeleteServicioException;
import javafxServerSide.exception.EditServicioException;
import javafxServerSide.exception.NewServicioException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Iker Jon Mediavilla
 */

@Stateless
public class ServicioEJB implements ServicioEJBLocal {

    private static final Logger logger = Logger.getLogger("javafxServerSide.ejb.ServicioEJB");   
       
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Servicio findServicioById(Integer id) throws ConsultaServicioException {
        logger.info("ServicioEJB: Finding Servicio by id");
        return em.find(Servicio.class, id);
    }
    
    @Override
    public void newServicio(Servicio servicio) throws NewServicioException {
       logger.info("ServicioEJB: New Servicio.");
       //validates data before inserting
       
        try{
             em.persist(servicio); 
        }catch(Exception e){
            logger.log(Level.SEVERE, "ServicioEJB: ConsultaServicioException creating Exception.", e.getMessage());
            throw new NewServicioException();
        }
    }
    
    @Override
    public Collection<Servicio> getAllServicios() throws ConsultaServicioException {
        try{
            logger.info("ServicioEJB: Getting all servicios.");
            Collection s = em.createNamedQuery("findAllServicios").getResultList(); 
            return s;
        }catch(Exception e){
             logger.log(Level.SEVERE, "ServicioEJB: Exception getting all servicios.{0}", e.getMessage());
            throw new ConsultaServicioException(e.getMessage());
        }
    }
    
    @Override
    public void deleteServicio(Servicio servicio) throws DeleteServicioException {
        try{
            logger.info("ServicioEJB: Deleting servicio.");
            //validates data before deleting 
            servicio=em.merge(servicio);
            em.remove(servicio);
        }catch(Exception e){
            logger.log(Level.SEVERE, "ServicioEJB: Exception deleting servicio.{0}", e.getMessage());
            throw new DeleteServicioException(e.getMessage());
        }
        logger.info("ServicioEJB: Servicio deleted.");
    }
    
    @Override
    public void editServicio(Servicio servicio) throws EditServicioException {
        try{
            logger.info("ServicioEJB: Editing servicio.");
            if(!em.contains(servicio)){
                servicio = em.merge(servicio);
            }
        }catch(Exception e){
            logger.log(Level.SEVERE, "ServicioEJB: Exception editing servicio.{0}", e.getMessage());
            throw  new EditServicioException(e.getMessage());
        }
        logger.info("ServicioEJB: Servicio edited.");
    }

    @Override
    public Collection<Servicio> getServiciosFiltrados(Integer tipo, Integer id, String nombre) throws ConsultaServicioException {
        try{
            Collection s;
             logger.info("ServicioEJB: Filtering servicios filter.");
            switch (tipo){
                case 0:
                    logger.info("ServicioEJB: Filtering servicios by findAllServicios.");
                    s = em.createNamedQuery("findAllServicios").getResultList();
                    break;
                    
                case 1:
                    logger.info("ServicioEJB: Filtering servicios by findServiciosId.");
                    s = em.createNamedQuery("findServiciosId").setParameter("id", id).getResultList();
                    break;
                    
                case 2:
                    logger.info("ServicioEJB: Filtering servicios by findServiciosNombre.");
                    s = em.createNamedQuery("findServiciosNombre").setParameter("nombre", nombre).getResultList();
                    break;
                    
                case 3:
                    logger.info("ServicioEJB: Filtering servicios by findServiciosIdNombre.");
                    s = em.createNamedQuery("findServiciosIdNombre").setParameter("id", id).setParameter("nombre", nombre).getResultList();
                    break;
                default:
                    logger.info("ServicioEJB: Filtering servicios by findAllServicios.");
                    s = em.createNamedQuery("findAllServicios").getResultList();
                    break;
            }
            logger.info("ServicioEJB: servicios filtered.");
            return s;
        }catch(Exception e){
            logger.log(Level.SEVERE, "ServicioEJB: Exception filtering servicios.{0}", e.getMessage());
            throw new ConsultaServicioException(e.getMessage());
        }
    }
    

    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
