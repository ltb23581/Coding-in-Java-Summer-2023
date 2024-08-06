package  b;
import a.Middle;

public class Side extends Middle {

    private int l;

    public Side( int a1, int a2, int a3, int a4, int a5 ) 
    { 
	super( a1, a2, a3, a4 ); 
	l = a5; 
    }

    public void doSomething( int a, int b ) 
    { 
	l = y * b + a; 
        System.out.println( "Side.doSomething(int,int)" );
    }

    public void access()
    {
	// x is not accessible: it is private
	// y is accessible: Middle is a subclass of Top
	// strange is not accessible: Side is in a different package
	// z is accessible: it is public
	// k is not accessible: it is private
    }
}
