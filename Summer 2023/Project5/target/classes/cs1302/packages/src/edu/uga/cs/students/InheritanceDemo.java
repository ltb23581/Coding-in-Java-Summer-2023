
package edu.uga.cs.students;

public class InheritanceDemo
{
    private final static int MAXSTUDENTS = 20;

    public static void main( String [] args )
    {
        Student[] students = new Student[ MAXSTUDENTS ];
	int noStudnets = 8;
	int i;

        students[0] = new Graduate( "Walt Barry", 5555555, "Masters", "Prof. Wise" );
        students[1] = new Undergraduate( "Mary Wilson", 3333333, 3 );
        students[2] = new Graduate( "Kim Rooker", 4444444, "Doctoral", "Prof. Tremor" );
        students[3] = new Undergraduate( "Jimmy Smith", 1111111, 1 );
        students[4] = new Undergraduate( "Natalie Olson", 8888888, 2 );
        students[5] = new Graduate( "Stephanie Long", 9999999, "Doctoral", "Prof. Wise" );
        students[6] = new Undergraduate( "Bobby Coe", 7777777, 4 );
        students[7] = new Undergraduate( "Will Rogers", 2222222, 1 );
	
	System.out.println( "List of students:\n" );
	for( i = 0; i < noStudnets; i++ )
	    System.out.println( students[i].toString() );

	System.out.println( "\nHere is what each student must do:\n" );
	for( i = 0; i < noStudnets; i++ )
	    System.out.println( students[i].getName() + ": " + students[i].toGraduate() );

	System.out.println( "\nHere is the class of each student:\n" );
	for( i = 0; i < noStudnets; i++ )
	    System.out.println( students[i].getClass().getSimpleName() + ": " + students[i].getName() );
    }
}
