package edu.uga.cs1302.shape;

import java.awt.Color;


/**
 * A simple 2-dimensional Circle.
 * 
 */
public class Circle extends Shape2D {

    private static final double PI = 3.14159;

    private int radius;

    /** 
     * Create a default Circle.
     * 
     */
    public Circle()
    { 
	super(Color.BLACK); 
	this.radius = 1; 
    }

    /** 
     * Create a Circle object.
     * 
     * @param color the color of the new Circle
     * @param radius the radius of the new Circle
     * @throws ShapeException if the radious is not positive
     */
    public Circle( Color color, int radius )
	throws ShapeException
    { 
	super(color); 

	if( radius <= 0 )
	    throw new ShapeException( "Circle: radius must be positive" );
	this.radius = radius; 
    }

    /** 
     * Return the radius of this Circle.
     * @return radius of the circle
     */
    public int getRadius()
    {
	return radius;
    }

    /** 
     * Set the new radius.
     * 
     * @param radius the new radius value
     */
    public void setRadius( int radius )
    {
	if( radius <= 0 )
	    throw new ShapeException( "Circle: radius must be positive" );
	this.radius = radius;
    }

    /** 
     * Compute the area of this circle.
     * 
     * @return the area of this circle
     */
    public int getArea() 
    { 
	return (int) (PI * radius * radius);
    }

    /** 
     * Return a String representation of this Circle.
     * 
     * @return String representing this Circle
     */
    public String toString()
    {
	return "Circle: radius: " + radius;
    }
}
