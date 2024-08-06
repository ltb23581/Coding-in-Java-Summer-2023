package edu.uga.cs1302.csvsample;

import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class CSVReader
{
    public static void main( String[] args )
    {
	try {
	    InputStream is = CSVReader.class.getClassLoader().getResourceAsStream("ranking.csv");
	    // In a non-static method, you would access the InputStream a bit differently:
	    // InputStream is = getClass().getClassLoader().getResourceAsStream("ranking.csv");
	    
	    Reader in = new BufferedReader( new InputStreamReader( is ) );
	    System.out.println( "Football team ranking from a memorable week..." );
	    Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
	    for (CSVRecord record : records) {
		//POS,TEAM,REC,PTS
		String position = record.get(0);
		String team = record.get(1);
		String rec = record.get(2);
		String points = record.get(3);
		System.out.println( position + " " + team + " " + rec + " " + points );
	    }
	}
	catch( IOException e ) {
	    System.out.println( e );
	}
    }
}
