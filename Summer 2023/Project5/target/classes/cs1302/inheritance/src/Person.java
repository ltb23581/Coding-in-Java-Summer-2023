class Person 
{
    private String name;
    private int age;

    public Person( String name, int age )
    { 
	this.name = name; this.age = age; 
    }

    public String getName() 
    { 
	return name; 
    }

    public void setName(String name) 
    { 
	this.name = name; 
    }        

    public int getAge() 
    { 
	return age; 
    }

    public void setAge(int age) 
    { 
	this.age = age; 
    }

    @Override
    public boolean equals(Object obj) {
	if( obj == this ) return true;
	if( obj == null 
	    || obj.getClass() != this.getClass() )
	    return false;

	// we need to downcast to access the other Person's
	// instance variables;  Object does not have a name and age!
	Person otherPerson = (Person) obj; // downcasting!
	return name != null && 
	    name.equals( otherPerson.name ) &&
	    age == otherPerson.age;
    }

    @Override
    public String toString()
    {
	return "Person: name: " + name + " age: " + age;
    }
}     
