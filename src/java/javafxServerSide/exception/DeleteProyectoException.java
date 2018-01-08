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
public class DeleteProyectoException extends Exception {

    /**
     * Creates a new instance of <code>DeleteProyectoException</code> without
     * detail message.
     */
    public DeleteProyectoException() {
    }

    /**
     * Constructs an instance of <code>DeleteProyectoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DeleteProyectoException(String msg) {
        super(msg);
    }
}
