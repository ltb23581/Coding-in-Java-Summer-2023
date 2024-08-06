import java.awt.Color;


// This is an abstract class and can't have any instances
//
public abstract class AbstractShape 
   implements Shape2D 
{

    // This is a standard representation of color in Java.
    // We will use it later in JavaFX
    protected Color color;

    public AbstractShape( Color color ) 
    { 
	this.color = color; 
    }

    public Color  getColor()
    {
	return color;
    }

    public void   setColor( Color color )
    {
	this.color = color;
    }

    // This method is not implemented here;
    // it is skipped, but any concrete class extending this class
    // will have to implement it, i.e., provide the body.
    // public abstract double getArea();
}
