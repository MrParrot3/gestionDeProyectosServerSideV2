/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxServerSide.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Past;

/**
 * Factura entity encapsulates the data of each invoice.
 * <ul>
 *  <li><stron>numFactura</strong> is the identifier of the invoice.</li>
 * <li><strong>fechaEmision</strong> is the date the invoice is drawn up.</li>
 * <li><strong>fechaVencimiento</strong> is the expiration date of an invoice.</li>
 * <li><strong>importe</strong> is the total amount of the invoice.</li>
 * <li><strong>estado</strong> points out whether the invoice has been paid or not.</li> * 
 * </ul>
 * @author Arantzazu Azkona
 */
@Entity
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String numFactura;    
    private Date fechaEmision;
    private Date fechaVencimiento;
    private Float importe;
    private Boolean estado;
    @ManyToOne
    private Cliente cliente;

    
    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    /**
     * Method used to compare two objects, provides the hash code of an object.
     * @return the hash code
     */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numFactura != null ? numFactura.hashCode() : 0);
        return hash;
    }
    /**
     * Method used to make equal comparison between two objects.
     * @param object
     * @return a boolean variable
     */

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.numFactura == null && other.numFactura != null) || (this.numFactura != null && !this.numFactura.equals(other.numFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javafxServerSite.Entity.Factura[ id=" + numFactura + " ]";
    }
    
}