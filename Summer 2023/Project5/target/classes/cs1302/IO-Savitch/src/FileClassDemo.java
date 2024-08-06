// this example is not from the book
//

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileClassDemo
{
    public static void main( String[] args )
    {
        Scanner keyboard = null;
        String  fileName = null;
	File    file     = null;

        System.out.print( "Enter file name: " );
        keyboard = new Scanner( System.in );
        fileName = keyboard.next ();

	file = new File( fileName );
        
	System.out.println( "File: " + file.getName() );

	System.out.println( "Path: " + file.getPath() );

	// check if exists
	if( file.exists() ) {
	    System.out.println( "Exists: yes" );
	}
	else {
	    System.out.println( "Exists: no" );
	    return;
	}

	System.out.println( "Size: " + file.length() );

	// check if a regular file
	if( file.isFile() )
	    System.out.println( "Regular file: yes" );
	else
	    System.out.println( "Regular file: no" );

	// check if a directory
	if( file.isDirectory() )
	    System.out.println( "Directory file: yes" );
	else
	    System.out.println( "Directory file: no" );

	// check if can be read
	if( file.canRead() )
	    System.out.println( "Can read: yes" );
	else
	    System.out.println( "can read: no" );

	// check if can be written
	if( file.canWrite() )
	    System.out.println( "Can write: yes" );
	else
	    System.out.println( "can write: no" );

	// show as a URI
	System.out.println( "URI: " + file.toURI() );

    }
}
