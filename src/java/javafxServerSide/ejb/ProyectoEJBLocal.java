/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxServerSide.ejb;

import java.util.Collection;
import javafxServerSide.entity.Proyecto;
import javafxServerSide.exception.ConsultaProyectoException;
import javafxServerSide.exception.DeleteProyectoException;
import javafxServerSide.exception.EditProyectoException;
import javafxServerSide.exception.NewProyectoException;
import javax.ejb.Local;

/**
 *
 * @author Iker Jon Mediavilla
 */
@Local
public interface ProyectoEJBLocal {
     
    /**
     * find a project by id
     * @param id
     * @return Proyecto
     * @throws ConsultaProyectoException 
     */
    public Proyecto findProyectoById(Integer id) throws ConsultaProyectoException;
    
    /**
     * find all projects
     * @return Collection<Proyecto>
     * @throws ConsultaProyectoException 
     */
    public Collection<Proyecto> getAllProyectos() throws ConsultaProyectoException;
    
    /**
     * create a new project
     * @param proyecto
     * @throws NewProyectoException 
     */
    public void newProyecto(Proyecto proyecto) throws NewProyectoException;
    
    /**
     * delete the project
     * @param proyecto
     * @throws DeleteProyectoException 
     */
    public void deleteProyecto(Proyecto proyecto) throws DeleteProyectoException;
    
    /**
     * edit the project
     * @param proyecto
     * @throws EditProyectoException 
     */
    public void editProyecto(Proyecto proyecto) throws EditProyectoException;    
    
    /**
     * parameterized queries to find project
     * @param tipo
     * @param nif
     * @return Collection<Proyecto>
     * @throws ConsultaProyectoException 
     */
    public Collection<Proyecto> getProyectosFiltrados(Integer tipo, String nif) throws ConsultaProyectoException;
}
