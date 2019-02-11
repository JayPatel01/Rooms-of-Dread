import java.util.Vector;

public class Place {
	
	private int roomID;
	private String roomName;
	private String discription;
	private Vector<Direction> dirVector=new Vector<Direction>();
	
	//Constructor.
	Place(int roomID, String roomName, String discription )
	{
		this.roomID=roomID;
		this.roomName=roomName;
		this.discription=discription;
	}
	
	public int getRoomID()
	{
		return roomID;
	}
	
	public String name()
	{
		return roomName;
	}
	
	//adds the directions of the places into the direction vector.
	public void addDirection(Direction addDir)
	{
		dirVector.addElement(addDir);
	}
	
	public String description()
	{
		return discription;
	}
	
	//follows the user inputed direction to make sure whether it matches one of the possible directions as well as,
	//whether the direction is locked or unlocked. 
	public Place followDirection(String userDir)
	{
		//Range based for loop...
		for(Direction tempDir: dirVector)
		{
			if(tempDir.match(userDir))
			{
				return tempDir.follow(); 
			}
		}
		return this;
	}
	

}
