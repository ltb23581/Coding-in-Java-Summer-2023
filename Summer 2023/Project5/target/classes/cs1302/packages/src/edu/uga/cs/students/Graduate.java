package edu.uga.cs.students;


public class Graduate extends Student
{
    private String degree;
    private String majorProf;
    
    public Graduate()
    {
        super();
	majorProf = "Undecided";
	degree = "Unknown";
    }

    public Graduate( String name, int number, String degree, String majorProf )
    {
        super( name, number );

        setDegree( degree ); // Checks degree validity
	this.majorProf = majorProf;
    }

    public String getDegree()
    {
        return degree;
    }

    public void setDegree( String degree )
    {
        if( degree.equals( "Masters" ) || degree.equals( "Doctoral" ) )
            this.degree = degree;
        else {
            System.err.println( "Graduate.setDegree: Illegal degree: " + degree );
        }
    }

    public String getMajorProf()
    {
        return majorProf;
    }

    public void setMajorProf( String majorProf )
    {
	this.majorProf = majorProf;
    }

    public String toGraduate()
    {
	if( degree.equals( "Masters" ) )
	    return "work hard on the thesis";
	else 
	    return "work hard on the dissertation";
    }

    // overridden toString
    //
    public String toString()
    {
	return "Graduate: Name: " + getName() + " Number: " + getNumber()
	       + " Degree: " + getDegree() + " Major Prof: " + getMajorProf();
    }

}
