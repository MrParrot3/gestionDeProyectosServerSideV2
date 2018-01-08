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
public class ConsultaProyectoException extends Exception {

    /**
     * Creates a new instance of <code>ConsultaProyectoException</code> without
     * detail message.
     */
    public ConsultaProyectoException() {
    }

    /**
     * Constructs an instance of <code>ConsultaProyectoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ConsultaProyectoException(String msg) {
        super(msg);
    }
}
