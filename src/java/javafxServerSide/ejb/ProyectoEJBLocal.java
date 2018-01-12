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
     
    public Proyecto findProyectoById(Integer id) throws ConsultaProyectoException;
    
    public Collection<Proyecto> getAllProyectos() throws ConsultaProyectoException;
     
    public void newProyecto(Proyecto proyecto) throws NewProyectoException;
    
    public void deleteProyecto(Proyecto proyecto) throws DeleteProyectoException;

    public void editProyecto(Proyecto proyecto) throws EditProyectoException;    
    
    public Collection<Proyecto> getProyectosFiltrados(Integer tipo, String nif) throws ConsultaProyectoException;
}
