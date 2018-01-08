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
public class NewProyectoException extends Exception {

    /**
     * Creates a new instance of <code>NewProyectoException</code> without
     * detail message.
     */
    public NewProyectoException() {
    }

    /**
     * Constructs an instance of <code>NewProyectoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NewProyectoException(String msg) {
        super(msg);
    }
}
