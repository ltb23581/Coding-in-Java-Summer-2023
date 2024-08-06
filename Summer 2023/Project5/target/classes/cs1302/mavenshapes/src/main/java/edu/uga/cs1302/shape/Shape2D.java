package edu.uga.cs1302.shape;

import java.awt.Color;


/**
 * An abstract class representing a simple 2-dimensional shape.
 *
 */
public abstract class Shape2D {

    /**
     * The color of this shape.
     * This is a standard representation of color in Java.
     * 
     */
    protected Color color;

    /** 
     * Create a new Shape2D object.
     * 
     * @param color the initial color of this shape
     */
    public Shape2D( Color color ) 
    { 
	this.color = color; 
    }

    /** 
     * Return the color of the Shape2D.
     * 
     * @return the color of this shape
     */
    public Color getColor()
    {
	return color;
    }

    /** 
     * Set the color of this Shape2D.
     * 
     * @param color the new color
     */
    public void setColor( Color color )
    {
	this.color = color;
    }
    
    /** 
     * An abstract method to compute the area of this Shape2D.
     * 
     * @return the area of this shape
     */
    public abstract int getArea();
}
