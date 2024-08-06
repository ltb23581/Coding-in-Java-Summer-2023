import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class JavaSimpleLinkedListTest
{
    public static void main( String[] args )
    {
	List<String> list = new LinkedList<String>();

	System.out.println( "List  empty: " + list.isEmpty() );
	System.out.println( "List length: " + list.size() );

	list.add( "two" );
	list.add( "three" );
	list.add( "five" );

	list.add( list.size(), "six" );
	list.add( 0, "one" );
	list.add( 3, "four" );

	System.out.println( "List  empty: " + list.isEmpty() );
	System.out.println( "List length: " + list.size() );

	System.out.println( "Element    0: " + list.get( 0 ) );
	System.out.println( "Element    2: " + list.get( 2 ) );
	System.out.println( "Element last: " + list.get( list.size()-1 ) );

	System.out.println( "Iterating forward" );
	ListIterator<String> iter = list.listIterator( 0 );
	while( iter.hasNext() ) {
	    System.out.println( "Previous index: " + iter.previousIndex() );
	    System.out.println( "    Next index: " + iter.nextIndex() );
	    System.out.println( iter.next() );
	}

	System.out.println( "Iterating backward" );
	while( iter.hasPrevious() ) {
	    System.out.println( "Previous index: " + iter.previousIndex() );
	    System.out.println( "    Next index: " + iter.nextIndex() );
	    System.out.println( iter.previous() );
	}

	System.out.println( "New iterator backward" );
	iter = list.listIterator( list.size() );
	while( iter.hasPrevious() ) {
	    System.out.println( "Previous index: " + iter.previousIndex() );
	    System.out.println( "    Next index: " + iter.nextIndex() );
	    System.out.println( iter.previous() );
	}

	System.out.println( "Removing first: " + list.remove( 0 ) );
	System.out.println( "Removing  last: " + list.remove( list.size()-1 ) );
	System.out.println( "Removing  3-rd: " + list.remove( 2 ) );

	System.out.println( "Iterating forward" );
	iter = list.listIterator( 0 );
	while( iter.hasNext() )
	    System.out.println( iter.next() );

	System.out.println( "Iterating backward" );
	while( iter.hasPrevious() )
	    System.out.println( iter.previous() );

	while( list.size() > 0 ) {
	    System.out.println( "Removing first: " + list.remove( 0 ) );
	    System.out.println( "List  empty: " + list.isEmpty() );
	    System.out.println( "List length: " + list.size() );
	}
    }
}
