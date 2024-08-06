import java.awt.Color;


// This is not an abstract class, so it is "concrete".
// It must define getArea().  But we know how to calculate
// a circlee's area.  It is a "concrete" shape.
public class Circle extends Shape2D {

    private static final double PI = 3.14159;

    private double radius;

    public Circle( Color color, double radius )
    { 
	super(color); 
	this.radius = radius; 
    }

    public double getRadius()
    {
	return radius;
    }

    public void setRadius( double radius )
    {
	this.radius = radius;
    }

    // We can compute the area of a circle.
    public double getArea() 
    { 
	return PI * radius * radius;
    }

    // Overridden toString()
    public String toString()
    {
	return "Circle: radius: " + radius;
    }
}
