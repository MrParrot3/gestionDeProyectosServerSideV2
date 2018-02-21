/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxServerSide.ejb;

import java.util.Collection;
import javafxServerSide.entity.Servicio;
import javafxServerSide.exception.ConsultaServicioException;
import javafxServerSide.exception.DeleteServicioException;
import javafxServerSide.exception.EditServicioException;
import javafxServerSide.exception.NewServicioException;
import javax.ejb.Local;

/**
 *
 * @author Iker Jon Mediavilla
 */
@Local
public interface ServicioEJBLocal {
    
    /**
     * find the service by id
     * @param id
     * @return Servicio
     * @throws ConsultaServicioException 
     */
    public Servicio findServicioById(Integer id) throws ConsultaServicioException;
    
   /**
     * find all service 
     * @return
     * @throws ConsultaServicioException 
     */
    public Collection<Servicio> getAllServicios() throws ConsultaServicioException;
    
     /**
     * create a new service
     * @param servicio
     * @throws NewServicioException 
     */
    public void newServicio(Servicio servicio) throws NewServicioException;
    
    /**
     * delete the service 
     * @param servicio
     * @throws DeleteServicioException 
     */
    public void deleteServicio(Servicio servicio) throws DeleteServicioException;
    
    /**
     * edit the service
     * @param servicio
     * @throws EditServicioException 
     */
    public void editServicio(Servicio servicio) throws EditServicioException;    
    
    /**
     * parameterized queries to find service
     * @param tipo
     * @param id
     * @param nombre
     * @return Collection<Servicio>
     * @throws ConsultaServicioException 
     */
    public Collection<Servicio> getServiciosFiltrados(Integer tipo, Integer id, String nombre) throws ConsultaServicioException;
    
   

}
