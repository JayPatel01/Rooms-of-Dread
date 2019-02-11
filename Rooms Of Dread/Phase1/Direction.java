
public class Direction {
	
	
	private boolean roomstatus;
	private int roomID;
	private Place from;
	private Place to;
	private String defaultDir;
	
	Direction(int ID, Place from, Place to, String dir)
	{
		roomID=ID;
		this.from=from;
		this.to=to;
		defaultDir=dir;
		roomstatus=false;
	}
	
	//Match function to check whether the user direction matches the default direction.
	public boolean match(String S)
	{
		if(S.equals(defaultDir))
		{
			return true;
		}
		return false;
	}
	
	public void lock()
	{
		roomstatus=true;
	}
	
	public void unlock()
	{
		roomstatus=false;
	}
	
	private boolean isLocked()
	{
		if(roomstatus)
		{
			System.out.println("The room you are tyring to get to is locked from this direction. Please try some other Direction.");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//follow function to return the appropriate place name i.e. if the place is locked then return the from place,
	//Otherwise return the to place.
	public Place follow()
	{
		if(isLocked())
		{
			return from;
		}
		else
		{
			return to;
		}
	}
	
	

}
