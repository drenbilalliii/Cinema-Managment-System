/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author Dren
 */
public class ShitjeException extends Exception {

    /**
     * Creates a new instance of <code>ShitjeException</code> without detail
     * message.
     */
    public ShitjeException() {
    }

    /**
     * Constructs an instance of <code>ShitjeException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ShitjeException(String msg) {
        super(msg);
    }
}
