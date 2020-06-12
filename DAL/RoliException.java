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
public class RoliException extends Exception {

    /**
     * Creates a new instance of <code>RoliException</code> without detail
     * message.
     */
    public RoliException() {
    }

    /**
     * Constructs an instance of <code>RoliException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public RoliException(String msg) {
        super(msg);
    }
}
