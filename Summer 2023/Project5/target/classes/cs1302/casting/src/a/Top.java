package  a;

public class Top {

    private int x;
    protected int y;
    int strange;
    public int z;

    // overloaded
    public Top() 
    { 
	this( 0, 0, 0 ); 
    }
    // overloaded
    public Top( int x, int y, int z ) 
    { 
	this.x = x; 
	this.y = y; 
	this.z = z; 
    }
    // overloaded
    public void doSomething( int a ) 
    { 
	x = y * 2 + a;
	System.out.println( "Top.doSomething(int)" );
    }
    // overloaded
    public void doSomething( int a, int b ) 
    { 
	x = y * b + a; 
	System.out.println( "Top.doSomething(int,int)" );
    }
}
