package edu.uga.cs1302.csvsample;

import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class CSVReader
{
    public static void main( String[] args )
    {
	try {
	    System.out.println( "Football team ranking from a great season..." );
	    Reader in = new FileReader( "/home/myid/kkochut/cs1302/ranking.csv" );
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
