package edu.uga.cs.students;


/**
 * @author Krys Kochut
 * 
 * A simple class to represent basic information about a person.
 * 
 */
public abstract class Person
{
    private String name;

    /** 
     * Create an uninitialized person object.
     * 
     */
    public Person()
    {
	// calling a different (overloaded) constructor
	this( "No name yet" );
    }

    /** 
     * Create a new person object
     * 
     * @param name the initial name of the person
     * 
     */
    public Person( String name )
    {
        this.name = name;
    }

    /** 
     * Return the current name of this person object
     * 
     * @return the current name
     */
    public String getName()
    {
        return name;
    }

    /** 
     * Set the new name for this person object.
     * 
     * @param name new name for this person
     */
    public void setName( String name )
    {
        this.name = name;
    }

    /** 
     * Return a String representation of this person object.
     * 
     * @return a representation of this person object
     */
    public String toString()
    {
        return "Person name: " + name ;
    }

}
