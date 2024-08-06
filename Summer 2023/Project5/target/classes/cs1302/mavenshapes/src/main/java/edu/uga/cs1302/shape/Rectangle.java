package edu.uga.cs1302.shape;

import java.awt.Color;


/**
 * A simple 2-dimensional shape: Rectangle.
 *
 */
public class Rectangle extends Shape2D {

    private int width;	// must be positive
    private int height;	// must be positive

    /** 
     * Create a default Rectangle object.
     *
     */
    public Rectangle()
    { 
	super(Color.BLACK); 
	this.width = 1;
	this.height = 1; 
    }

    /** 
     * Create a new Rectangle with given parameter values.
     * 
     * @param color color of the new Rectangle
     * @param width width of the new Rectangle
     * @param height height of the new Rectangle
     * @throws ShapeException if the width or height are not positive
     */
    public Rectangle( Color color, int width, int height )
	throws ShapeException
    { 
	super(color); 

	if( width <= 0 )
	    throw new ShapeException( "Rectangle: width must be positive" );
	this.width = width;

	if( height <= 0 )
	    throw new ShapeException( "Rectangle: height must be positive" );
	this.height = height; 
    }

    /** 
     * Return the width of the Rectangle.
     * 
     * @return the width of this Rectangle
     */
    public int getWidth()
    {
	return width;
    }

    /** 
     * Set the new width of this Rectangle.
     * 
     * @param width the new width
     * @throws ShapeException if the width is not positive
     */
    public void setWidth( int width )
	throws ShapeException
    {
	if( width <= 0 )
	    throw new ShapeException( "Rectangle: width must be positive" );
	this.width = width;
    }

    /** 
     * Return the height of this Rectangle.
     * 
     * @return height of this Rectangle
     */
    public int getHeight()
    {
	return height;
    }

    /** 
     * Set the new height of this Rectangle.
     * 
     * @param height the new height
     * @throws ShapeException if the height is not positive
     */
    public void setHeight( int height )
	throws ShapeException
    {
	if( height <= 0 )
	    throw new ShapeException( "Rectangle: height must be positive" );
	this.height = height;
    }

    /** 
     * Compute the area of this Rectangle.
     * 
     * @return the area of this Rectangle
     */
    public int getArea() 
    { 
	return width * height;
    }

    /** 
     * Compare thie Rectangle to enother for equality.
     * 
     * @param obj the other object to compare; it should be a Rectangle
     * 
     * @return true if the two Rectangles have the same widths AND heights and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
	if( obj == this ) return true;
	if( obj == null 
	    || obj.getClass() != this.getClass() )
	    return false;

	// we need to downcast to access the other Rectangle's
	Rectangle otherRectangle = (Rectangle) obj; // downcasting!
	return color != null && 
	    color.equals( otherRectangle.color ) &&
	    width == otherRectangle.width &&
	    height == otherRectangle.height;
    }

    /** 
     * Return a String representation of this Rectangle.
     * 
     * @return String representing this Rectangle
     */
    @Override
    public String toString()
    {
	return "Rectangle: color: " + color + " width: " + width + " height: " + height;
    }
}
