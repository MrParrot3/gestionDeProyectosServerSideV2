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
public class DeleteServicioException extends Exception {

    /**
     * Creates a new instance of <code>DeleteServicioException</code> without
     * detail message.
     */
    public DeleteServicioException() {
    }

    /**
     * Constructs an instance of <code>DeleteServicioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DeleteServicioException(String msg) {
        super(msg);
    }
}
