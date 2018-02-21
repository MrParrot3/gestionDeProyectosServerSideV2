/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxServerSide.exception;

/**
 *
 * @author Iker Jon Mediavilla
 */
public class ConsultaServicioException extends Exception {

    /**
     * Creates a new instance of <code>ConsultaServicioException</code> without
     * detail message.
     */
    public ConsultaServicioException() {
    }

    /**
     * Constructs an instance of <code>ConsultaServicioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ConsultaServicioException(String msg) {
        super(msg);
    }
}
