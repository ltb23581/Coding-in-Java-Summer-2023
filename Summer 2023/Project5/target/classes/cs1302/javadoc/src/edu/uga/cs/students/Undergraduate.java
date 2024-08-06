package edu.uga.cs.students;

/**
 * @author Krys Kochut
 * 
 * A simple class representing an undergrad student.
 * 
 */
public class Undergraduate extends Student
{
    private int year; // 1 for freshman, 2 for sophomore,
                      // 3 for junior, or 4 for senior.
    
    /** 
     * Cretae an uninitialized undergraduate student
     */
    public Undergraduate()
    {
        super();
        year = 1;
    }

    /** 
     * Create a new Undergraduate student object
     * 
     * @param name the name of the undergrad student
     * @param number the number of the new student
     * @param year the year of the new student
     * 
     */
    public Undergraduate( String name, int number, int year )
    {
        super( name, number );
        setYear( year ); // Checks 1 <= year <= 4
    }

    /** 
     * Return the current year of this undergrad student
     * 
     * @return the year of this undergrad student
     */
    public int getYear()
    {
        return year;
    }

    /** 
     * Set the new year of this undergrad student
     * 
     * @param year the new year; it must be 1 through 4, inclusive
     */
    public void setYear(int year)
    {
        if( (1 <= year) && (year <= 4) )
            this.year = year;
        else {
            System.err.println( "Undergraduate.setYear: Illegal year: " + year );
        }
    }

    /** 
     * Return a String indicating what this undergrad student needs to do to graduate
     * 
     * @return what to do to graduate
     */
    public String toGraduate()
    {
	if( year == 4 )
	    return "study hard; the end is in sight!";
	else
	    return "study hard for " + (5 - year) + " years";
    }

    /** 
     * Get a string representing this undergrad student object
     * 
     * @return a representation of this undergrad student object
     */
    public String toString()
    {
	return "Undergraduate: Name: " + getName() + " Number: " + getNumber() + " Year: " + getYear();
    }

}
