package edu.uga.cs.students;


public abstract class Person
{
    private String name;

    public Person()
    {
	// calling a different (overloaded) constructor
	this( "No name yet" );
    }

    public Person( String name )
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String toString()
    {
        return "Person name: " + name ;
    }

}
