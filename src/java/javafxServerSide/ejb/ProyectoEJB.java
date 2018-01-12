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
import javafxServerSide.entity.Proyecto;
import javafxServerSide.entity.Servicio;
import javafxServerSide.exception.ConsultaProyectoException;
import javafxServerSide.exception.ConsultaServicioException;
import javafxServerSide.exception.DeleteProyectoException;
import javafxServerSide.exception.EditProyectoException;
import javafxServerSide.exception.NewProyectoException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Iker Jon Mediavilla
 */
@Stateless
public class ProyectoEJB implements ProyectoEJBLocal {
    
    //logger for the class
    private static final Logger logger = Logger.getLogger("javafxServerSide.ejb.ProyectoEJB");
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Proyecto findProyectoById(Integer id) throws ConsultaProyectoException{
        logger.info("ProyectoEJB: Finding proyecto by id.");
        return em.find(Proyecto.class, id);
    } 
    
    @Override
    public void newProyecto(Proyecto proyecto) throws NewProyectoException{
        logger.info("ProyectoEJB: New Proyecto.");
        //validates data before inserting
      
        /*if(proyecto.getId()==null || proyecto.getCliente()==null || proyecto.getConcepto() == null || proyecto.getHorasEstimadas() == null ||
            proyecto.getImporteEstimado() == null || proyecto.getFechaEstimada() == null){
            logger.severe("ProyectoEJB: ConsultaProyectoException creating Exception ");
            throw new NewProyectoException();
       
        }*/
        try{
             em.persist(proyecto); 
        }catch(Exception e){
            logger.log(Level.SEVERE, "ProyectoEJB: ConsultaProyectoException creating Exception.", e.getMessage());
            throw new NewProyectoException();
        }
    }
    
    @Override
    public Collection<Proyecto> getAllProyectos() throws ConsultaProyectoException{
        try{
            logger.info("ProyectoEJB: Getting all proyectos.");
            Collection p = em.createNamedQuery("findAllProyectos").getResultList(); 
            return p;
        }catch(Exception e){
             logger.log(Level.SEVERE, "ProyectoEJB: Exception getting all proyectos.{0}", e.getMessage());
            throw new ConsultaProyectoException(e.getMessage());
        }

    }
    
    @Override
    public void deleteProyecto(Proyecto proyecto) throws DeleteProyectoException{
        try{
            logger.info("ProyectoEJB: Deleting proyecto.");
            //validates data before deleting 
            proyecto=em.merge(proyecto);
            em.remove(proyecto);
        }catch(Exception e){
            logger.log(Level.SEVERE, "ProyectoEJB: Exception deleting proyecto.{0}", e.getMessage());
            throw new DeleteProyectoException(e.getMessage());
        }
        logger.info("ProyectoEJB: Proyecto deleted.");
    }
    
    @Override
    public void editProyecto(Proyecto proyecto) throws EditProyectoException{
        try{
            logger.info("ProyectoEJB: Editing proyecto.");
            if(!em.contains(proyecto)){
                proyecto = em.merge(proyecto);
            }
        }catch(Exception e){
            logger.log(Level.SEVERE, "ProyectoEJB: Exception editing proyecto.{0}", e.getMessage());
            throw  new EditProyectoException(e.getMessage());
        }
        logger.info("ProyectoEJB: Proyecto edited.");
    }
    
    @Override
    public Collection<Proyecto> getProyectosFiltrados(Integer tipo, String nif) throws ConsultaProyectoException{
        try{
            Collection p;
            logger.info("ProyectoEJB: Filtering proyectos filter.");
            switch (tipo){
                case 0:
                    logger.info("ProyectoEJB: Filtering proyectos by findProyectosSinFinalizar.");
                    p = em.createNamedQuery("findProyectosSinFinalizar").getResultList();
                    break;
                    
                case 1:
                    logger.info("ProyectoEJB: Filtering proyectos by findProyectosFinalizados.");
                    p = em.createNamedQuery("findProyectosFinalizados").getResultList();
                    break;
                    
                case 2:
                    logger.info("ProyectoEJB: Filtering proyectos by findAllProyectos.");
                    p = em.createNamedQuery("findAllProyectos").getResultList();
                    break;
                    
                case 3:
                    logger.info("ProyectoEJB: Filtering proyectos by findProyectosCIF.");
                    p = em.createNamedQuery("findProyectosNIF").setParameter("nif", nif).getResultList();
                    break;
                    
                case 4:
                    logger.info("ProyectoEJB: Filtering proyectos by findProyectosSinFinalizarCIF.");
                    p = em.createNamedQuery("findProyectosSinFinalizarNIF").setParameter("nif", nif).getResultList();
                    break;
                    
                case 5:
                    logger.info("ProyectoEJB: Filtering proyectos by findProyectosFinalizadosCIF.");
                    p = em.createNamedQuery("findProyectosFinalizadosNIF").setParameter("nif", nif).getResultList();
                    break;
                    
                default:
                   logger.info("ProyectoEJB: Filtering proyectos by findAllProyectos.");
                    p = em.createNamedQuery("findAllProyectos").getResultList();
                    break;
            }
            logger.info("ProyectoEJB: Proyectos filtered.");
            return p;
        }catch(Exception e){
            logger.log(Level.SEVERE, "ProyectoEJB: Exception filtering proyectos.{0}", e.getMessage());
            throw new ConsultaProyectoException(e.getMessage());
        }
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
