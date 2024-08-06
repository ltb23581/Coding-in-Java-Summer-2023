package edu.uga.cs1302.food;



public class Restaurant
{
    private String name;
    private String type;
    private String description;
    private String address;
    
    public Restaurant()
    {
        this.name = null;
        this.type = null;
        this.description = null;
        this.address = null;
    }
    
    public Restaurant( String name, String type, String description, String address )
    {
        this.name = name;
        this.type = type;
        this.description = description;
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType( String type )
    {
        this.type = type;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    @Override
	public String toString()
    {
        return "Restaurant [name=" + name + ", type=" + type + ", description=" + description
	    + ", address=" + address + "]";
    }
    
}
