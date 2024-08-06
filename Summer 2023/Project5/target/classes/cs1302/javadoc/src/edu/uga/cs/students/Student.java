package edu.uga.cs.students;

/**
 * @author Krys Kochut
 * 
 * A simple abstract class representing a studnet.
 * 
 */
public abstract class Student extends Person
{
    private int number;

    /** 
     * Create a new Student object.
     * 
     */
    public Student()
    {
        super();
        number = 0; //Indicating no number yet
    }

    /** 
     * Create a new Student object
     * 
     * @param name the initial name of the student
     * @param number the initial number of the student
     * 
     */
    public Student( String name, int number )
    {
        super(name);
        this.number = number;
    }

    /** 
     * Return the current student number of this student
     *
     * @return the current student number
     */
    public int getNumber()
    {
        return number;
    }

    /** 
     * Set the new number of this student
     * 
     * @param number the new student number
     */
    public void setNumber(int number)
    {
        this.number = number;
    }

    /** 
     * Return a String indicating what this student needs to do to graduate
     * 
     * @return what to do to graduate
     */
    public abstract String toGraduate();

    /** 
     * Get a string representing this object
     * 
     * @return a representation of this student object
     */
    public String toString()
    {
	return "Student: " + getName() + "; number: " + number;
    }

    /** 
     * Check if the two Student objects are equal
     * 
     * @param otherObject the other Student object for the comparison
     * 
     * @return true if the two students are equal, false otherwise
     */
    public boolean equals(Object otherObject)
    {
    	boolean isEqual = false;

    	if( (otherObject != null) &&
	    (otherObject instanceof Student)) {
	    Student otherStudent = (Student) otherObject;
	    isEqual = getName().equals( otherStudent.getName() ) 
		      && number == otherStudent.number;
	}

	return isEqual;
    }
}
