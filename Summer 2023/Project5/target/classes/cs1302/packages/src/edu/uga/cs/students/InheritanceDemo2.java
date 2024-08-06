
package edu.uga.cs.students;

public class InheritanceDemo2
{
    private final static int MAXSTUDENTS = 20;

    public static void main (String [] args)
    {
        Student[]     students = new Student[ MAXSTUDENTS ];
	Graduate      grad;
	Undergraduate ugrad;
	int           noStudnets = 8;
	int           i;


        students[0] = new Graduate( "Walt Barry", 5555555, "Masters", "Prof. Wise" );
        students[1] = new Undergraduate( "Mary Wilson", 3333333, 3 );
        students[2] = new Graduate( "Kim Rooker", 4444444, "Doctoral", "Prof. Tremor" );
        students[3] = new Undergraduate( "Jimmy Smith", 1111111, 1 );
        students[4] = new Undergraduate( "Natalie Olson", 8888888, 2 );
        students[5] = new Graduate( "Stephanie Long", 9999999, "Doctoral", "Prof. Wise" );
        students[6] = new Undergraduate( "Bobby Coe", 7777777, 4 );
        students[7] = new Undergraduate( "Will Rogers", 2222222, 1 );
	
	System.out.println( "\nDetailed information:\n" );
	for( i = 0; i < noStudnets; i++ ) {
	    if( students[i] instanceof Graduate ) {
		// this is a graduate student
		grad = (Graduate) students[i]; // downcasting, but it's safe!
		System.out.println( grad.getName() + ", a grad student; degree objective: " 
				    + grad.getDegree() + "; major prof: " + grad.getMajorProf() );
	    }
	    else if( students[i] instanceof Undergraduate ) {
                // this is a graduate student
                ugrad = (Undergraduate) students[i]; // downcasting, but it's safe!
                System.out.println( ugrad.getName() + ", an undergrad student; year: " + ugrad.getYear() );
            }
	    else
		System.out.println( "Unknown student type at index: " + i );
	}
    }
}
