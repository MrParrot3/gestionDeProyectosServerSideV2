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
public class NewServicioException extends Exception {

    /**
     * Creates a new instance of <code>NewServicioException</code> without
     * detail message.
     */
    public NewServicioException() {
    }

    /**
     * Constructs an instance of <code>NewServicioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NewServicioException(String msg) {
        super(msg);
    }
}
