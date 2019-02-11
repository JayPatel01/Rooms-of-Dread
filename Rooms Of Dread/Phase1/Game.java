import java.util.Vector;
import java.util.Scanner;

public class Game {
	
	
	private String gameName;
	private Place currentPlace=null;
	private Vector<Place> placeVector=new Vector<Place>();
	
	Game(String usergameName)
	{
		gameName=usergameName;
	}
	
	public String getGameName()
	{
		return gameName;
	}
	
	//adding the places to the place vector using the inbuilt function for vectors.(addElement()).
	public void addPlace(Place place)
	{
		placeVector.addElement(place);
	}
	
	public void play()
	{
		String playerInput="";
		boolean flag=false;
		
		@SuppressWarnings("resource")
		Scanner input= new Scanner(System.in);
		
		System.out.println("");
		
		System.out.println("Welcome to the ROOM PUZZLE..good luck");
		System.out.println("");
		
		System.out.println("Here are the Choices: ");
		System.out.println("1. Enter QUIT or EXIT : to exit or stop plaing the game at anytime. ");
		System.out.println("2. Enter LOOK : to see where you are in the game board. Also to see the details of the room.");
		System.out.println("3. Enter Directions : like N,S,E,W,U,D to play the game. ");

		currentPlace = placeVector.get(0);
		
		//Loop until user wants to exit or quit the game.
		while(!playerInput.equals("EXIT") || !playerInput.equals("QUIT")||
				!playerInput.equals("exit") || !playerInput.equals("quit")||
				!playerInput.equals("Exit") || !playerInput.equals("Quit"))
		{	
			flag=false;
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
				
				//Gives you the description of the current place.
				System.out.println(currentPlace.description());
			}
			
			//Probable Enhancement: checks for most of the user variations. 
			if(playerInput.equals("GO N") ||
					playerInput.equals("GO NORTH")||
					playerInput.equals("GO North")||
					playerInput.equals("GO north")||
					playerInput.equals("Go North")||
					playerInput.equals("Go north")||
					playerInput.equals("NORTH")||
					playerInput.equals("North")||
					playerInput.equals("north")||
					playerInput.equals("N")||
					playerInput.equals("n")||
					playerInput.equals("Go N")||
					playerInput.equals("Go n")||
					playerInput.equals("go N")||
					playerInput.equals("go n"))
			{
				playerInput="N";
				flag=true;
				//To change the current place as player moves, as well as to follow the direction.
				currentPlace=currentPlace.followDirection("N");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations. 
			if(playerInput.equals("GO S")||
					playerInput.equals("GO SOUTH")||
					playerInput.equals("GO South")||
					playerInput.equals("GO south")||
					playerInput.equals("Go South")||
					playerInput.equals("Go south")||
					playerInput.equals("go South")||
					playerInput.equals("go south")||
					playerInput.equals("SOUTH")||
					playerInput.equals("South")||
					playerInput.equals("south")||
					playerInput.equals("S")||
					playerInput.equals("s")||
					playerInput.equals("Go S")||
					playerInput.equals("Go s")||
					playerInput.equals("go S")||
					playerInput.equals("go s"))
			{
				playerInput="S";
				flag=true;
				currentPlace=currentPlace.followDirection("S");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations. 
			if(playerInput.equals("GO E")||
					playerInput.equals("GO EAST")||
					playerInput.equals("GO East")||
					playerInput.equals("GO east")||
					playerInput.equals("Go East")||
					playerInput.equals("Go east")||
					playerInput.equals("EAST")||
					playerInput.equals("East")||
					playerInput.equals("east")||
					playerInput.equals("E")||
					playerInput.equals("e")||
					playerInput.equals("Go E")||
					playerInput.equals("Go e")||
					playerInput.equals("go E")||
					playerInput.equals("go e"))
			{
				playerInput="E";
				flag=true;
				currentPlace=currentPlace.followDirection("E");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations. 
			if(playerInput.equals("GO W")||
					playerInput.equals("GO WEST")||
					playerInput.equals("GO West")||
					playerInput.equals("GO west")||
					playerInput.equals("GO West")||
					playerInput.equals("GO west")||
					playerInput.equals("WEST")||
					playerInput.equals("West")||
					playerInput.equals("west")||
					playerInput.equals("W")||
					playerInput.equals("w")||
					playerInput.equals("Go W")||
					playerInput.equals("Go w")||
					playerInput.equals("go W")||
					playerInput.equals("go w"))
			{
				playerInput="W";
				flag=true;
				currentPlace=currentPlace.followDirection("W");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations. 
			if(playerInput.equals("GO U")||
					playerInput.equals("GO UP")||
					playerInput.equals("GO Up")||
					playerInput.equals("GO up")||
					playerInput.equals("Go Up")||
					playerInput.equals("Go up")||
					playerInput.equals("UP")||
					playerInput.equals("Up")||
					playerInput.equals("up")||
					playerInput.equals("U")||
					playerInput.equals("u")||
					playerInput.equals("Go U")||
					playerInput.equals("Go u")||
					playerInput.equals("go U")||
					playerInput.equals("go u"))
			{
				playerInput="U";
				flag=true;
				currentPlace=currentPlace.followDirection("U");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations. 
			if(playerInput.equals("GO D")||
					playerInput.equals("GO DOWN")||
					playerInput.equals("GO Down")||
					playerInput.equals("GO down")||
					playerInput.equals("Go DOWN")||
					playerInput.equals("Go down")||
					playerInput.equals("DOWN")||
					playerInput.equals("Down")||
					playerInput.equals("down")||
					playerInput.equals("D")||
					playerInput.equals("d")||
					playerInput.equals("Go D")||
					playerInput.equals("Go d")||
					playerInput.equals("go D")||
					playerInput.equals("go d"))
			{
				playerInput="D";
				flag=true;
				currentPlace=currentPlace.followDirection("D");
				System.out.println("You are in " + currentPlace.name() + ".");
			}
			
			//Checks to see if you have reached the EXIT place or not.
			if(currentPlace.getRoomID()==00)
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

}
