import java.awt.Color;


// This is not an abstract class, so it is "concrete"
// It must define getArea().  But we know how to calculate
// a triangle's area.  It is a "concrete" shape.
public class Triangle extends Shape2D {

    private double base;
    private double height;

    public Triangle( Color color, double base, double height )
    { 
	super(color); 
	this.base = base; 
	this.height = height; 
    }

    public double getBase()
    {
	return base;
    }

    public void setBase( double base )
    {
	this.base = base;
    }

    public double getHeight()
    {
	return height;
    }

    public void setHeight( double height )
    {
	this.height = height;
    }

    // We can compute the area of a triangle.
    public double getArea() 
    { 
	return base * height / 2;
    }

    // Overridden toString()
    public String toString()
    {
	return "Triangle: base: " + base + " height: " + height;
    }
}
