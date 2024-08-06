package edu.uga.cs1302.shape;

import java.awt.Color;


/**
 * A simple 2-dimensional shape: Triangle.
 *
 */
public class Triangle extends Shape2D {

    private int base;	// must be positive
    private int height;	// must be positive

    /** 
     * Create a default Triangle object.
     *
     */
    public Triangle()
    { 
	super(Color.BLACK); 
	this.base = 1; 
	this.height = 1; 
    }

    /** 
     * Create a new Triangle with given parameter values.
     * 
     * @param color color of the new Rectangle
     * @param base base of the new Triangle
     * @param height height of the new Triangle
     * @throws ShapeException if the base or height are not positive
     */
    public Triangle( Color color, int base, int height )
	throws ShapeException
    { 
	super(color); 

	if( base <= 0 )
	    throw new ShapeException( "Triangle: base must be positive" );
	this.base = base; 

	if( height <= 0 )
	    throw new ShapeException( "Triangle: height must be positive" );
	this.height = height; 
    }

    /** 
     * Return the base of the Triangle.
     * 
     * @return the base of this Triangle
     */
    public int getBase()
    {
	return base;
    }

    /** 
     * Set the new base of this Triangle.
     * 
     * @param base the new base
     * @throws ShapeException if the base is not positive
     */
    public void setBase( int base )
	throws ShapeException
    {
	if( base <= 0 )
	    throw new ShapeException( "Triangle: base must be positive" );
	this.base = base;
    }

    /** 
     * Return the height of this Triangle.
     * 
     * @return height of this Triangle
     */
    public int getHeight()
    {
	return height;
    }

    /** 
     * Set the new height of this Triangle.
     * 
     * @param height the new height
     * @throws ShapeException if the height is not positive
     */
    public void setHeight( int height )
	throws ShapeException
    {
	if( height <= 0 )
	    throw new ShapeException( "Triangle: height must be positive" );
	this.height = height;
    }

    /** 
     * Compute the area of this Triangle.
     * 
     * @return the area of this Triangle
     */
    public int getArea() 
    { 
	return base * height / 2;
    }

    /** 
     * Return a String representation of this Triangle.
     * 
     * @return String representing this Triangle
     */
    @Override
    public String toString()
    {
	return "Triangle: base: " + base + " height: " + height;
    }
}
