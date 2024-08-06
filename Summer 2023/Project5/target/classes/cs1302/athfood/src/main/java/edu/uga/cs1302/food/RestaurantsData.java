package edu.uga.cs1302.food;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class RestaurantsData
{
    private List<Restaurant> restaurants;
    private List<Restaurant> restaurantsOfType;
    private int size;

    public RestaurantsData()
    {
        this.restaurants = new ArrayList<Restaurant>();
	size = 0;
	try {
	    InputStream is = getClass().getClassLoader().getResourceAsStream("restaurants.csv");
	    Reader in = new BufferedReader( new InputStreamReader( is ) );
	    Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);

	    for (CSVRecord record : records) {
		if( size > 0 ) { // skip row 0 -- headings
		    String name = record.get(0);
		    String type = record.get(1);
		    String description = record.get(2);
		    String address = record.get(3);
		    Restaurant restaurant = new Restaurant( name, type, description, address );
		    //System.out.println( restaurant );
		    restaurants.add( restaurant );
		}
		size++;
	    }
	    System.out.println( "RestaurantsData: number of restaurants: " + restaurants.size() );
	}
	catch( IOException e ) {
	    System.out.println( e );
	}
        restaurantsOfType = new ArrayList<Restaurant>();
    }

    public List< Restaurant > getRestaurants()
    {
        return restaurants;
    }

    public void setRestaurants( List< Restaurant > restaurants )
    {
        this.restaurants = restaurants;
    }
    
    public void addRestaurant( Restaurant restaurant )
    {
        if( restaurant == null )
            return;
        restaurants.add( restaurant );
    }

    public List<Restaurant> getType( String type )
    {
	restaurantsOfType.clear();
	for( Restaurant restaurant : restaurants )
	    if( restaurant.getType().equals( type ) )
		restaurantsOfType.add( restaurant );
	return restaurantsOfType;
    }

    @Override
	public String toString()
    {
        return "RestaurantsData [restaurants=" + restaurants + "]";
    }    
}
