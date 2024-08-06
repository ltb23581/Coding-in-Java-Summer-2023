package edu.uga.cs1302.shape;

// a simple exception class
// it is an unchecked exception
/**
 * A ShapeException class to indicate any problem with a 2-dimensional shape.
 * 
 */
public class ShapeException extends RuntimeException 
{

    /** 
     * Create a default ShapeException.
     * 
     */
    public ShapeException() {
        super();
    }

    /** 
     * Create a ShapeException with a given message.
     * 
     * @param msg a message describing this ShapeException
     */
    public ShapeException( String msg ) {
        super( msg );
    }
}
