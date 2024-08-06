import a.Top;
import a.Middle;
import a.Bottom;
import b.Side;

public class Test
{
    public static void main( String[] args )
    {
	Top    t;
	Middle m;
	Bottom b;
	Side   s;

	b = new Bottom(1, 2, 3, 4, 5);
	m = b;   // up-casting
	t = b;   // up-casting

	m = (Middle) t; // down-casting; ok in this case; a Bottom 
                        // object is-a Middle object too
	b = (Bottom) t; // down-casting; ok in this case
	//s = (Side) t;   // down-casting, but not OK, since Bottom cannot be cast to Side
                        // and will cause a ClassCastException
	                // uncomment this line and recompile the program to see this exception

	m.doSomething( 11, 12 ); // m refers to a Bottom object so 
                                 // s doSomething is called
	t.doSomething( 11, 12 ); // t refers to a Bottom object so 
                                 // s doSomething is called 
    }
}
