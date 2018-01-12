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
     
    public Servicio findServicioById(Integer id) throws ConsultaServicioException;
    
    public Collection<Servicio> getAllServicios() throws ConsultaServicioException;
     
    public void newServicio(Servicio servicio) throws NewServicioException;
    
    public void deleteServicio(Servicio servicio) throws DeleteServicioException;

    public void editServicio(Servicio servicio) throws EditServicioException;    
    
    public Collection<Servicio> getServiciosFiltrados(Integer tipo, Integer id, String nombre) throws ConsultaServicioException;
    
    //falta la de asociar proyecto con servicio

}
