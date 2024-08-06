import java.util.Stack;

public class TowersOfHanoiNonRec {

    static Stack<TowersState> towersStack = new Stack<TowersState>();

    // count the number of required disk moves
    public static int noMoves = 0;

    // move n disks from fromPeg to toPeg, using sparePeg as an auxliary peg
    //
    public static void towers( int n, char fromPeg, char toPeg, char sparePeg )
    {
	TowersState towersState = null;
	int         callNo = 0;

	towersStack.push( new TowersState( n, fromPeg, toPeg, sparePeg, 0 ) );

	while( !towersStack.empty() ) {
			  
	    towersState = towersStack.pop();

	    n        = towersState.getN();
	    fromPeg  = towersState.getFromPeg();
	    toPeg    = towersState.getToPeg();
	    sparePeg = towersState.getSparePeg();
	    callNo   = towersState.getCallNo();
	    
	    if( callNo == 0 ) {
		if( n == 1) {		// move just one disk -- simple
		    System.out.println( "move disk 1 from peg " + fromPeg +
					" to peg " + toPeg );
		    noMoves++;
		}
		else {			// move more than 1 disks

		    towersStack.push( new TowersState( n, fromPeg, toPeg, sparePeg, 1 ) );
		    towersStack.push( new TowersState( n-1, fromPeg, sparePeg, toPeg, 0 ) );
		}
	    }
	    else {		// second call to towers

		// now, move the remaining disk from fromPeg to toPeg (the destination)
		System.out.println( "move disk " + n + " from peg " + fromPeg +
				    " to peg " + toPeg );
		noMoves++;

		// finally, move the n-1 from sparePeg to toPeg (the destination)
		towersStack.push( new TowersState( n-1, sparePeg, toPeg, fromPeg, 0 ) );
	    }
	}
    }
    
    public static void main( String[] args )
    {
	int noOfDisks = 3;

	try {
	    if( args.length > 0 )
		noOfDisks = Integer.parseInt( args[0] );
	}
	catch( NumberFormatException nfe ) {
	    System.err.println( "Number of disks must be a positive integer" );
	    return;
	}
	if( noOfDisks <= 0 ) {
	    System.err.println( "Number of disks must be a positive integer" );
	    return;
	}

	towers( noOfDisks, 'A', 'B', 'C' );
	System.out.println( "The transfer required " + noMoves + " moves" );
    }
}
