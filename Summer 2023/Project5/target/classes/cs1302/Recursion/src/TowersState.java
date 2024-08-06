    public class TowersState {

	private int  n;
	private char fromPeg;
	private char toPeg;
	private char sparePeg;
	private int  callNo;

	TowersState( int n, char fromPeg, char toPeg, char sparePeg, int callNo )
	{
	    this.n        = n;
	    this.fromPeg  = fromPeg;
	    this.toPeg    = toPeg;
	    this.sparePeg = sparePeg;
	    this.callNo   = callNo;
	}

	int  getN() { return n; }

	char getFromPeg() { return fromPeg; }
    
	char getToPeg() { return toPeg; }
    
	char getSparePeg() { return sparePeg; }

	int  getCallNo() { return callNo; }
    }

