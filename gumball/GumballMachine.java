public class GumballMachine
{

    private int num_gumballs;
    private boolean onlyQuarters;
    private int cost;
    private int amount_inputted = 0;

    public gumball( int size, int price, boolean onlyQuarters )
    {
        // initialise instance variables
        this.num_gumballs = size;
        this.cost = price;
    }

    public void insertCoin(String coin)
    {
    	if (coin.equalsIgnoreCase("quarter") && !this.onlyQuarters)
    	{
        	this.amount_inputted += 25;
    	}
    	else if (coin.equalsIgnoreCase("dime") && !this.onlyQuarters)
    	{
    		this.amount_inputted += 10;
    	}
    	else if (coin.equalsIgnoreCase("nickel") && !this.onlyQuarters)
    	{
    		this.amount_inputted += 5;
    	}
    	else if (coin.equalsIgnoreCase("penny") && !this.onlyQuarters)
    	{
    		this.amount_inputted += 1;
    	}
    	else
    	{
    		if(this.onlyQuarters)
    			System.out.println("This machine only accepts quarters.");
    		else
    			System.out.println("Not a valid coin. Please insert a quarter, dime, nickel, or penny");
    	}
    }
    
    public void turnCrank()
    {
    	if ( this.amount_inputted == this.cost )
    	{
    		if ( this.num_gumballs > 0 )
    		{
    			this.num_gumballs-- ;
    			this.amount_inputted = 0;
    			System.out.println( "Thanks for your quarter.  Gumball Ejected!" ) ;
    		}
    		else
    		{
    			System.out.println( "No More Gumballs!  Sorry, can't provide refund." ) ;
    		}
    	}
    	else 
    	{
    		System.out.println(this.amount_inputted);
    		System.out.println( "Please insert to coins that add up to "+this.amount_inputted);
    		int needed = this.cost - this.amount_inputted;
    		System.out.println( "You need "+ needed);
    	}        
    }
    
	public static void main(String[] args)
	{
		// Parameters for gumball (amount_of_gumballs, price, boolean onlyQuarters)
		gumball gumball1 = new gumball(50, 75, false);
		gumball1.insertCoin("quarter");
		gumball1.insertCoin("quarter");
		gumball1.insertCoin("quarter");
		gumball1.turnCrank();
		gumball1.insertCoin("quarter");
		gumball1.insertCoin("penny");
		gumball1.turnCrank();
		System.out.println("Done");
	}
}

