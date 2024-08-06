public class Test
{
    public static void main( String[] args )
    {
	Person p;
	Student s;
	GradStudent gs;

	s = new Student( "Joe Smith", 21, "CS" );
	gs = new GradStudent( "Becky Wilson", 25, "CS", "Dr. Quick" );

	p = s;  // upcasting
	
        s = (Student) p;  // downcasting;  explicit typecast required

	/*
	gs = (GradStudent) p;  // downcasting but it won't work!
	*/

	p = gs;
	s = gs;
	gs = (GradStudent) p;  // downcasting; will be OK 
	s = (Student) p; // downcasting; will be OK GradStudent is-a Student
	

	System.out.println( s.toString() );
	System.out.println( p.toString() );
    }
}
