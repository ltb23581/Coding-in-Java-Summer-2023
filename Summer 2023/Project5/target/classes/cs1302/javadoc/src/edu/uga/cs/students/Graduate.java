package edu.uga.cs.students;

/**
 * @author Krys Kochut
 * 
 * A simple class representing a graduate student.
 */
public class Graduate extends Student
{
    private String degree;
    private String majorProf;
    
    /** 
     * Cretae an uninitialized graduate student
     */
    public Graduate()
    {
        super();
	majorProf = "Undecided";
	degree = "Unknown";
    }

    /** 
     * Create a new Graduate student object
     * 
     * @param name the name of the grad student
     * @param number the student number of the new grad student
     * @param degree the degree objective
     * @param majorProf the major professor of the new student
     * 
     */
    public Graduate( String name, int number, String degree, String majorProf )
    {
        super( name, number );

        setDegree( degree ); // Checks degree validity
	this.majorProf = majorProf;
    }

    /** 
     * Return the current degree objective of this grad student
     * 
     * @return the degree objective of this grad student
     */
    public String getDegree()
    {
        return degree;
    }

    /** 
     * Set the new degree objective for this grad student
     * 
     * @param degree the new degree objective
     */
    public void setDegree( String degree )
    {
        if( degree.equals( "Masters" ) || degree.equals( "Doctoral" ) )
            this.degree = degree;
        else {
            System.err.println( "Graduate.setDegree: Illegal degree: " + degree );
        }
    }

    /** 
     * Return the current major professor of this grad student
     * 
     * @return the major professor of this grad student
     */
    public String getMajorProf()
    {
        return majorProf;
    }

    /** 
     * Set the new major professor for this grad student
     * 
     * @param majorProf the new major professor
     */
    public void setMajorProf( String majorProf )
    {
	this.majorProf = majorProf;
    }

    /** 
     * Return a String indicating what this grad student needs to do to graduate
     * 
     * @return what to do to graduate
     */
    public String toGraduate()
    {
	if( degree.equals( "Masters" ) )
	    return "work hard on the thesis";
	else 
	    return "work hard on the dissertation";
    }

    /** 
     * Get a string representing this object
     * 
     * @return a representation of this grad student object
     */
    public String toString()
    {
	return "Graduate: Name: " + getName() + " Number: " + getNumber()
	       + " Degree: " + getDegree() + " Major Prof: " + getMajorProf();
    }

}
