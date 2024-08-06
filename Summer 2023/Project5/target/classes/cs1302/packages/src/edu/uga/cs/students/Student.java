package edu.uga.cs.students;


public abstract class Student extends Person
{
    private int number;

    public Student()
    {
        super();
        number = 0; //Indicating no number yet
    }

    public Student( String name, int number )
    {
        super(name);
        this.number = number;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public abstract String toGraduate();

    // overridden toString
    //
    public String toString()
    {
	return "Student: " + getName() + "; number: " + number;
    }

    // overridden equals
    //
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
