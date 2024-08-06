package edu.uga.cs.students;

public class Undergraduate extends Student
{
    private int year; // 1 for freshman, 2 for sophomore,
                      // 3 for junior, or 4 for senior.
    
    public Undergraduate()
    {
        super();
        year = 1;
    }

    public Undergraduate(String name, int number, int year)
    {
        super( name, number );
        setYear( year ); // Checks 1 <= year <= 4
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        if( (1 <= year) && (year <= 4) )
            this.year = year;
        else {
            System.err.println( "Undergraduate.setYear: Illegal year: " + year );
        }
    }

    public String toGraduate()
    {
	if( year == 4 )
	    return "study hard; the end is in sight!";
	else
	    return "study hard for " + (5 - year) + " years";
    }

    // overridden toString
    //
    public String toString()
    {
	return "Undergraduate: Name: " + getName() + " Number: " + getNumber() + " Year: " + getYear();
    }

}
