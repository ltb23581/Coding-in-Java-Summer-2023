package  a;

public class Middle extends Top {

    private int k;

    public Middle() 
    { 
	k = 0; 
    }

    public Middle( int p, int q, int r, int s ) 
    { 
	super( p, q, r ); 
	k = s; 
    }

    public void doSomething( int a, int b ) 
    { 
	super.doSomething( a, b );
	k = y * 40 + a * super.z; 
        System.out.println( "Middle.doSomething(int,int)" );
    }

    public void access()
    {
	// x is not accessible: it is private
	// y is accessible: Middle is a subclass of Top
	// strange is accessible: Middle is in the same package
	// z is accessible: it is public
    }
}
