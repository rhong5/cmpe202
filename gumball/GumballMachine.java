public class GumballMachine
{

    private int num_gumballs;
    private boolean onlyQuarters;
    private int cost;
    private int amount_inputted = 0;

    public GumballMachine( int size, int price, boolean onlyQuartersFlag )
    {
        // initialise instance variables
        this.num_gumballs = size;
        this.cost = price;
        this.onlyQuarters = onlyQuartersFlag;
    }

    public void insertCoin(String coin)
    {
    	if (coin.equalsIgnoreCase("quarter"))
    	{
        	this.amount_inputted += 25;
    		System.out.println( "~~>Quarter added!");
    	}
    	else if (coin.equalsIgnoreCase("dime") && !this.onlyQuarters)
    	{
    		this.amount_inputted += 10;
    		System.out.println( "~~>Dime added!");
    	}
    	else if (coin.equalsIgnoreCase("nickel") && !this.onlyQuarters)
    	{
    		this.amount_inputted += 5;
    		System.out.println( "~~>Nickel added!");
    	}
    	else if (coin.equalsIgnoreCase("penny") && !this.onlyQuarters)
    	{
    		this.amount_inputted += 1;
    		System.out.println( "~~>Penny added!");
    	}
    	else
    	{
    		if(this.onlyQuarters)
    			System.out.println("~~>This machine only accepts quarters.");
    		else
    			System.out.println("~~>Not a valid coin. Please insert a quarter, dime, nickel, or penny");
    	}
    }
    
    public void turnCrank()
    {
    	if ( this.amount_inputted >= this.cost )
    	{
    		if ( this.num_gumballs > 0 )
    		{
    			this.num_gumballs-- ;
    			this.amount_inputted = 0;
    			System.out.println( "~~>Payment received!  Gumball Ejected!\n" ) ;
    		}
    		else
    		{
    			System.out.println( "~~>No More Gumballs!  Sorry, can't provide refund.\n" ) ;
    		}
    	}
    	else 
    	{
    		int needed = this.cost - this.amount_inputted;
    		System.out.println( "~~>Please insert to coins that add up to "+this.cost+'.');
    		System.out.println( "~~>You need "+ needed+ " cents more");
    	}        
    }
    
	public static void main(String[] args)
	{
		// Parameters for gumball (amount_of_gumballs, price, boolean onlyQuarters)
		
		System.out.println( "This gumball machine cost 25 cents,  and only accepts quarters.");
		GumballMachine gumball1 = new GumballMachine(25, 25, true);
		gumball1.insertCoin("quarter");
		gumball1.turnCrank();
		System.out.println( "This gumball machine cost 50 cents,  and only accepts quarters.");
		GumballMachine gumball2 = new GumballMachine(25, 50, true);
		gumball2.insertCoin("quarter");
		gumball2.insertCoin("quarter");
		gumball2.turnCrank();
		System.out.println( "This gumball machine cost 50 cents,  and accepts all coins.");
		GumballMachine gumball3 = new GumballMachine(25, 50, false);
		gumball3.insertCoin("quarter");
		gumball3.insertCoin("dime");
		gumball3.insertCoin("dime");
		gumball3.insertCoin("nickel");
		gumball3.insertCoin("penny");
		gumball3.insertCoin("penny");
		gumball3.insertCoin("penny");
		gumball3.insertCoin("penny");
		gumball3.insertCoin("penny");
		gumball3.turnCrank();
		
		System.out.println( "Fail Case: No more Gumballs :(");
		GumballMachine gumball4 = new GumballMachine(1, 25, true);
		gumball4.insertCoin("quarter");
		gumball4.turnCrank();
		gumball4.insertCoin("quarter");
		gumball4.turnCrank();
		
		System.out.println( "Fail Case: Receives coins other than quarters:");
		GumballMachine gumball5 = new GumballMachine(1, 50, true);
		gumball5.insertCoin("quarter");
		gumball5.insertCoin("dime");
		gumball5.insertCoin("penny");
		gumball5.turnCrank();
		
	}
}

