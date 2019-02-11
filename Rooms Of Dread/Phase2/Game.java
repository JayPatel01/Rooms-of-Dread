//Game class for the control of the entire game functions.

import java.util.Vector;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
	
	private String gameName;
	private static Place currentPlace;
	//place vector that contains all the place objects.
	private Vector<Place> placeVector=new Vector<Place>();
	//direction vector that contains all the direction objects.
	private Vector<Direction> directVect=new Vector<Direction>();
	//Artifact vector that contains all the artifact objects.
	private Vector<Artifact>artiVect=new Vector<Artifact>();
	//Artifact Hashmap to look for the appropriate Artifact.
	private HashMap<String,Artifact>artiHMap2=new HashMap<String,Artifact>();
	private int artiNum=0;
	private float num=0;
	private String trimmed=null;
	private String firstString=null;
	private String nameGame=null;
	
	//using the whole file as a scanner in Game constroctor...
	Game(Scanner fileIn)
	{	
		while(fileIn.hasNextLine())
		{
			//getting the trimmed line from the file.
			trimmed= getCleanLine(fileIn);
			
			if(trimmed == null)
			{
				break;
			}
			@SuppressWarnings("resource")
			//using the trimmed line as a scanner input.
			Scanner inputLine= new Scanner(trimmed);
			
			firstString=inputLine.next();
			
			if("GDF".equalsIgnoreCase(firstString))
				{
					num=inputLine.nextFloat();
					nameGame=inputLine.nextLine();
				}
			
			//Checking for the file data if it contains Place informations.
			if("PLACES".equalsIgnoreCase(firstString))
			{
				int placeNum=0;
				placeNum=inputLine.nextInt();
				
				Place Exit=new Place(1,"EXIT","This is the exit place");
				placeVector.add(Exit);
				Place Knowhere=new Place(0,"Knowhere","There is no way out from here.");
				placeVector.add(Knowhere);
				
				for(int i=0;i<placeNum;i++)
				{	
					Place object=new Place(fileIn);
					placeVector.add(object);
				}
			}
			
			//Checking for the file data if it contains Directions' informations.
			if("DIRECTIONS".equalsIgnoreCase(firstString))
			{
				int dirNum=0;
				dirNum=inputLine.nextInt();
				for(int j=0;j<dirNum;j++)
				{
					Direction object1=new Direction(fileIn);
					directVect.add(object1);
				}
			}
			//Chceking for the file data if it contains Artifacts' informations.
			if("ARTIFACTS".equalsIgnoreCase(firstString))
			{
				int artiNum=0;
				artiNum=inputLine.nextInt();
				
				for(int k=0;k<artiNum;k++)
				{
					Artifact object2=new Artifact(fileIn);
					artiVect.add(object2);
				}
			}//end if()	
		}//end while loop to read the file till the end.
	}//end of the Game constroctor.
	
	//Printing the vector information from the placeVector.
	void printVec()
	{
		for(int i=0;i<placeVector.size();i++)
		{
			System.out.println(placeVector.get(i).getRoomID());
			System.out.println(placeVector.get(i).name());
			System.out.println(placeVector.get(i).description());
			//System.out.println(placeVector.get(i).getRoomID());
		}
	}

	//getting the clean line function.
	static String getCleanLine(Scanner fileIn)
	{
		while (fileIn.hasNextLine())
		{
			String L=null;
			String subLine=null;
			L=fileIn.nextLine();
			//Condition for the blank line from the file.
			if(L.length()==0)
			{
				continue;
			}
			
			//Condition for the line that starts with the comments.
			if(L.startsWith("//"))
			{
				continue;
			}
			//conditions for the line that contains comment mark.
			if(L.contains("//"))
			{
				subLine=L.substring(0, L.indexOf("//")).trim();
				return subLine;
			}
			else
			{
				subLine=L.trim();
				return subLine;
			}
		}
		return null;
	}//end of the Lean line function.
	
	//getting the gameName.
	public String getGameName()
	{
		return gameName;
	}
	
	//getting current Place.
	static Place getCurrentPlace()
	{
		return currentPlace;
	}
	
	//adding the places to the place vector using the inbuilt function for vectors.(addElement()).
	public void addPlace(Place place)
	{
		placeVector.add(place);
	}
	
	//getting the Artifact function to enable GET command for the user.
	public void getArtifect(String two)
	{
		Artifact getArti = currentPlace.placeArtiPlay(two);
		if ( getArti!= null)
		{
			artiHMap2.put(two, getArti);
			System.out.println ("Now...Trasfering '" +two +"' in to the player's Inventory...\n\n");
			artiNum++;   
		}
		else
		{
			System.out.println ("Nothing is added in this player's possesionss....");
		}
		
	}
	//dropping the Aritifact to enable DROP command for the user.
	public void dropArtifact(String two)
	{
		if ( artiHMap2.containsKey(two))
		{
			System.out.println ("Now...Dropping the '" +two +"' from the player's bag...\n\n");
			Artifact dropArti = artiHMap2.get(two);
			currentPlace.getFromPlayer (dropArti, two);
			artiHMap2.remove(two);
			artiNum--;  
		}
		else
		{
			System.out.println ("This '" +two+"', you are trying to drop is not in the player's Inventory...");
		}
	}
	//useing the Artifact function to enable the USE command for the user.
	public void useArtifact(String two)
	{
		if ( artiHMap2.containsKey(two))
		{
			artiHMap2.get(two).use();
		}
		else
		{
			System.out.println ("This '" +two+"', you are trying to use is not in the player's Inventory...");
		}	
	}
	
	//function to display the instructions of the game.
	public void Instructions()
	{
		System.out.println("Welcome to the 'Mystic City'..good luck");
		System.out.println("");
		
		System.out.println("Here are the Choices: ");
		System.out.println("1. Enter QUIT or EXIT : to exit or stop plaing the game at anytime. ");
		System.out.println("2. Enter LOOK : to see where you are in the game board. Also to see the details of the room.");
		System.out.println("3. Enter Directions : like N,S,E,W,U,D to play the game. ");
		System.out.println("4. Enter GET <keyname> : to Pick up the key from the room.");
		System.out.println("5. Enter USE <keyname> : to use the Key from your bag and open the room.");
		System.out.println("6. Enter DROP <keyname> : to drop the key from your bag.");
		System.out.println("7. Enter INVE or INVENTORY: to see what you have in your bag.");
	}
	
	//Function to play the game....
	public void play()
	{
		String playerInput="";
		boolean flag=false;
		
		@SuppressWarnings("resource")
		Scanner input= new Scanner(System.in);
		
		Instructions();
		System.out.println("");
		currentPlace = placeVector.get(2);
		
		//Loop until user wants to exit or quit the game.
		while(!playerInput.equals("EXIT") || !playerInput.equals("QUIT")||
				!playerInput.equals("exit") || !playerInput.equals("quit")||
				!playerInput.equals("Exit") || !playerInput.equals("Quit"))
		{	
			flag=false;
			System.out.println("Enter your Choice =:> ");
			playerInput=input.nextLine();
			
			if(playerInput.equals("EXIT") || playerInput.equals("QUIT")||
					playerInput.equals("exit") || playerInput.equals("quit")||
					playerInput.equals("Exit") || playerInput.equals("Quit"))
			{
				System.out.println("Thanks For Playing ... Hope to See you soon.");
				break;
			}
			if(playerInput.equals("LOOK")||playerInput.equals("look")||playerInput.equals("Look"))
			{
				flag=true;
				currentPlace.print();
			}
			String inputPart1="";
			String inputPart2="";
			if ( playerInput.contains("GET") ||
				 playerInput.contains("DROP")||
				 playerInput.contains("USE") ||
				 playerInput.contains("get") ||
				 playerInput.contains("drop")||
				 playerInput.contains("use") ||
				 playerInput.contains("Get") ||
				 playerInput.contains("Drop")||
				 playerInput.contains("Use")  )
			{
				flag=true;
				inputPart1 =  playerInput.substring( 0 , playerInput.indexOf(" "));
				inputPart2 = playerInput.substring( playerInput.indexOf(" ")+1 , playerInput.length());	
				
				if(inputPart1.equalsIgnoreCase("GET"))
				{
					getArtifect(inputPart2);
				}
				if(inputPart1.equalsIgnoreCase("DROP"))
				{
					dropArtifact(inputPart2);
				}
				if(inputPart1.equalsIgnoreCase("USE"))
				{
					useArtifact(inputPart2);
				}
				
			}
			
			//Probable Enhancement: checks for most of the user variations. 
			if(Direction.DirType.north.match(playerInput))
			{
				flag=true;
				//To change the current place as player moves, as well as to follow the direction.
				currentPlace=currentPlace.followDirection("N");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations.
			if(Direction.DirType.south.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("S");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations.
			if(Direction.DirType.east.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("E");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations.
			if(Direction.DirType.west.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("W");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations. 
			if(Direction.DirType.up.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("U");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations. 
			if(Direction.DirType.down.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("D");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			
			if(Direction.DirType.northNorthEast.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("NNE");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			if(Direction.DirType.eastNorthEast.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("ENE");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			if(Direction.DirType.northNorthWest.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("NNW");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			if(Direction.DirType.westNorthWest.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("WNW");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			if(Direction.DirType.southSouthWest.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("SSW");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			if(Direction.DirType.westSouthWest.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("WSW");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			if(Direction.DirType.southSouthEast.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("SSE");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			if(Direction.DirType.eastSouthEast.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("ESE");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			if(Direction.DirType.northEast.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("NE");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			if(Direction.DirType.southEast.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("SE");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			if(Direction.DirType.northWest.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("NW");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			if(Direction.DirType.southWest.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("SW");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			if(Direction.DirType.none.match(playerInput))
			{
				flag=true;
				currentPlace=currentPlace.followDirection("NONE");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			if(playerInput.equalsIgnoreCase("INVENTORY") || playerInput.equalsIgnoreCase("INVE"))
			{
				flag=true;
				System.out.println ( "Player's Inventory information:"+"\n");
				//for loop to print the inventory of the player.
				for( HashMap.Entry <String, Artifact> getKey :  artiHMap2.entrySet()) 
				{
					  String key = getKey.getKey();
					  Artifact inventory = getKey.getValue();
					  
					  System.out.println("----------------------------------------------------------");
					  System.out.println("|    Name of the Artifact : " +  inventory.name() +"                |");
					  System.out.println("|    Size of the Artifact : " +   inventory.size()+"                            |");
					  System.out.println("|    Value of the Artifact: " +   inventory.value()+"                           |");
					  System.out.println("----------------------------------------------------------");
				}
				
				System.out.println ( "Total Artifacts with the Player : " + artiNum );
				System.out.println("----------------------------------------------------------"+"\n");
			}
			
			//Checks to see if you have reached the EXIT place or not.
			if(currentPlace.getRoomID()==1)
			{
				flag=true;
				System.out.println("YAY! You found it...Well Done.");
			}
			
			//For the error message if user types something other than expected input.
			if(flag==false)
			{
				System.out.println("Not a Valid command, Please Try again.");
			}
				
		}//End of the While loop
	}//End of the play() function.
}//end of the Game Class.
