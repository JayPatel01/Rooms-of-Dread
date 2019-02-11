//Place class for the rooms and places to be managed and have functions.


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;

public class Place {
	
	private int roomID;
	private String roomName;
	private String discription="";
	//to hold the direction objects...
	private Vector<Direction> dirVector=new Vector<Direction>();
	//private Vector<Artifact>artiVec=new Vector<Artifact>();
	
	//static place map to store all the places..
	//------------------------------------------------------------------------
	private static TreeMap<Integer,Place>placeMap=new TreeMap<Integer,Place>();
	//Hash map for the Artifacts...
	private HashMap<String,Artifact>artiHMap=new HashMap<String,Artifact>();
	//Vector for the Characters.
	//-------------------------------------------------------------------------
	public Vector<Character>placeCharVec = new Vector<Character>(); 
	
	Place p;
	
	//Constructor for Exit and Knowhere place...
	Place(int ID,String rName, String Disc)
	{
		roomID=ID;
		roomName=rName;
		discription=Disc;
		placeMap.put(roomID, this);
	}
	
	//Constructor which will read from the file and get the data... 
	Place (Scanner fileIn1)
	{
		int discNum=0;
		String trimmed1=null;
		trimmed1=CleanLineScanner.getCleanLine(fileIn1);
		@SuppressWarnings("resource")
		Scanner inputLine1=new Scanner(trimmed1);
		
		roomID=inputLine1.nextInt();
		roomName=(inputLine1.nextLine()).trim();
		discNum=fileIn1.nextInt();
		
		
		
		//For loop for the number of line discription...
		for(int n=0;n<discNum;n++)
		{
			trimmed1=CleanLineScanner.getCleanLine(fileIn1);
			@SuppressWarnings("resource")
			Scanner temp=new Scanner(trimmed1);
			discription=discription+"\n"+temp.nextLine();
		}
		//putting created place into the Map with roomID=key and Place=Value.
		placeMap.put(roomID, this);
	}//end of the file constructor.
	
	//function to access the direction vector...
	public Vector<Direction> getdirection()
	{
		return dirVector;
	}
	
	//Add Artifact function to add artifacts into the Artifacts' Hash map.
	void addArtifact(String artiName,Artifact artifact)
	{
		artiHMap.put(artiName.trim(), artifact);
	}
	
	//adding the character..
	public void addPlaceCharVec(Character P)
	{
		placeCharVec.addElement(P);
	}
	
	public void removePlaceCharVec(Character P)
	{
		placeCharVec.removeElement(P);
	}
	
	//static so that it has access to it from all the classes.
	static Place getPlaceByID(int ID)
	{
		return placeMap.get(ID);
	}
	
	//Function to implement the useKey capebilities for the user...
	void useKey(Artifact artifact1)
	{
		for( int i=0; i < dirVector.size(); i++)
		{
				dirVector.get(i).useKey(artifact1);
		 } 
	}
	
	//Function to get Artifact from the player for when he drops it.
	public void getFromPlayer ( Artifact drop , String key)
	{
		artiHMap.put( key, drop);
	}
	
	//Function to get the Artifact from the Place to the Player's Inventory.
	public Artifact placeArtiPlay ( String key)
	{
		if ( artiHMap.containsKey( key))
		{
			Artifact get = artiHMap.get(key);
			artiHMap.remove(key);
			return get;
		
		}
		else
		{
			System.out.println (" Sorry there is no artifact in this room") ;
			return null;
		}	
	}
	
	//print function to print out when user types in "look"
	public void print(IO IO_Obj1)
	{
		//IO_Obj1 = new IO();
//		System.out.println ("ID of the place: " + this.roomID);
//		System.out.println ("Name of the place: " + this.roomName);
//		System.out.println ("Description of the place: " + this.discription);	
//		System.out.println("");
//		System.out.println ("This place has following artifacts: ");
		
		IO_Obj1.display ("ID of the place: " + this.roomID);
		IO_Obj1.display ("Name of the place: " + this.roomName);
		IO_Obj1.display ("Description of the place: " + this.discription);	
		IO_Obj1.display ("");
		IO_Obj1.display ("This place has following artifacts: ");
		
		for( Map.Entry <String, Artifact> entry : artiHMap.entrySet()) 
		{
			  String key = entry.getKey();
			  Artifact value = entry.getValue();

//			  System.out.println("--------------------------------------------------------");
//			  System.out.println("Name of the Artifact: " +  value.name());
//			  System.out.println("Size of the Artifact: " +  value.size());
//			  System.out.println("Value of the Artifact:" +   value.value());
//			  System.out.println("Discription : "+value.ArtiDescription());
//			  System.out.println("--------------------------------------------------------");
			  
			  IO_Obj1.display("--------------------------------------------------------");
			  IO_Obj1.display("Name of the Artifact: " +  value.name());
			  IO_Obj1.display("Size of the Artifact: " +  value.size());
			  IO_Obj1.display("Value of the Artifact:" +   value.value());
			  IO_Obj1.display("Discription : "+value.ArtiDescription());
			  IO_Obj1.display("--------------------------------------------------------");
		}
		System.out.println ("");
		IO_Obj1.display("");
		
	}
	
	//getiing the room ID.
	public int getRoomID()
	{
		return roomID;
	}
	
	//getting the room name.
	public String name()
	{
		return roomName;
	}
	
	//adds the directions of the places into the direction vector.
	public void addDirection(Direction addDir)
	{
		dirVector.add(addDir);
		
	}
	
	//getting the room discription.
	public String description()
	{
		return discription;
	}
	
	//follows the user inputed direction to make sure whether it matches one of the possible directions as well as,
	//whether the direction is locked or unlocked. 
	public Place followDirection(String userDir)
	{
		for(int i=0; i<dirVector.size();i++)
		{
			if((dirVector.get(i)).match(userDir))
			{
				return (dirVector.get(i)).follow();
			}
		}
		return this;
	}//end of the function
	
}//End of the Direction class.
