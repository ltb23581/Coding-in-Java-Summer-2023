import java.awt.Color;


// This is not an abstract class, so it is "concrete".
// It must define getArea().  But we know how to calculate
// a rectangle's area.  It is a "concrete" shape.
public class Rectangle extends AbstractShape {

    private double width;
    private double height;

    public Rectangle( Color color, double width, double height )
    { 
	super(color); 
	this.width = width;
	this.height = height; 
    }

    public double getWidth()
    {
	return width;
    }

    public void setWidth( double width )
    {
	this.width = width;
    }

    public double getHeight()
    {
	return height;
    }

    public void setHeight( double height )
    {
	this.height = height;
    }

    // We can compute the area of a rectangle.
    public double getArea() 
    { 
	return width * height;
    }

    // Overridden toString()
    public String toString()
    {
	return "Rectangle: width: " + width + " height: " + height;
    }
}
