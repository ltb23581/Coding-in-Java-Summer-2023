package edu.uga.cs1302.quiz;

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

public class CountryCollection {
    private List<Country> countries;
    private List<Country> countryContinents;
    private int size;

    public CountryCollection() {
        this.countries = new ArrayList<Country>();
        size = 0;
        try {
        	InputStream is = getClass().getClassLoader().getResourceAsStream("country_continent.csv");
        	Reader in = new BufferedReader(new InputStreamReader(is));
        	Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
        	
        	for(CSVRecord record : records) {
        		if(size > 0) {
        			String name = record.get(0);
        			String continent = record.get(1);
        			Country country = new Country(name, continent);
        			System.out.println(country);
        			countries.add(country);
        		}
			size++;
        	}
        	System.out.println("CountriesData: number of countries: " + countries.size());
        }
        catch(IOException e) {
        	System.out.println(e);
        }
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public void addCountries(Country country) {
    	if(country == null)
    		return;
    	countries.add(country);
    }
    
    public List<Country> getContinent(String continent){
    	countryContinents.clear();
    	for(Country country : countries) {
    		if(country.getContinent().equals(continent)) {
    			countryContinents.add(country);
    		}
    	}
    	return countryContinents;
    }
    
    @Override
    public String toString() {
    	return "CountriesData [countries=" + countries + "]";
    }
}