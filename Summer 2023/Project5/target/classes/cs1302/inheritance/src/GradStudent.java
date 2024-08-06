class GradStudent extends Student {

    private String majorProfessor;

    public GradStudent( String name, int age, String major, String majorProfessor )
    { 
	super( name, age, major ); 
	this.majorProfessor = majorProfessor;
    }

    public String getMajorProfessor()
    {
	return majorProfessor;
    }

    public void setMajorProfessor( String majorProfessor)
    {
	this.majorProfessor = majorProfessor;
    }

    @Override
    public String toString()
    {
	return "GradStudent: name: " + getName() + " age: " + getAge() + " major: " + getMajor() + " prof: " + majorProfessor;
    }
}     
