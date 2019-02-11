//project4 ni character.java file
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

//The character class.....this inputs the implementation of different characters from the file.

public class Character {
	
	//character ID.
	private int cID;
	//Character's current place.
	private int cPlace;
	//Name of the chcracter..
	private String cName;
	//Discription of the Character
	private String cDisc="";
	private int nDisc;
	//Character Vector to store character objects.
	//-----------------------------------------------------------------
	//change
	public Vector<Character> charVec = new Vector<Character>();
	//Character Artifacts Vector to store the artifacts fo the chcrater.
	public static Vector<Artifact> charArti = new Vector<Artifact> ();
	//Hash map of chcracter ID and Character Objects...
	public static HashMap<Integer, Character> charHash = new HashMap<Integer, Character>();
	//Place vector to generate the randome place for NPC.
	private Vector<Place> placeVec2 = new Vector<Place> ();
	
	//badaliu
	public Vector<Character>placeCharVec = new Vector<Character>();
	//Current Place...
	//-----------------------------------------------------
	private Place currentPlaceChar;
	private String charType;
	//private static int ExitCounter=0;
	public IO IO_Obj;
    
	public Character ( int idChar, String nameChar, String discChar)
	{
		charType = "PLAYER";
		placeVec2 = Game.getPlaceVec2();
		//int rendomNum1 = new Random().nextInt(placeVec2.size());
		//rendomNum1 = placeVec2.get(rendomNum1).getRoomID();
		cPlace = 12;
		currentPlaceChar = Place.getPlaceByID(cPlace);
		
		cID = idChar;
		cName = nameChar;
		cDisc = discChar;
		
System.out.println("Please Select the Interface you want to Play with :=> ");
		
		Scanner numIn = new Scanner(System.in);
		int numberIn = numIn.nextInt();
		
		IO_Obj = new IO();
		IO_Obj.select(numberIn);
		
		
		//charVec.add(this);
		charHash.put(cID, this);
		currentPlaceChar.addPlaceCharVec(this);
	}
	
	public Character (Scanner G1, double Version)
	{
		//constructor to check the name and the version of the game.
	}
	
	public Character (Scanner fileIn)
	{
		String trimmed2=null;
		//getting the trimmed line from the file.
		trimmed2=CleanLineScanner.getCleanLine(fileIn);
		@SuppressWarnings("resource")
		//using the trimmed line as a scanner input.
		Scanner inputLine3=new Scanner(trimmed2);
		
		//String charType=null;
		
		charType = inputLine3.nextLine();
		
		String trimmed3=CleanLineScanner.getCleanLine(fileIn);
		@SuppressWarnings("resource")
		//using the trimmed line as a scanner input.
		Scanner inputLine4=new Scanner(trimmed3);
		
		cPlace = inputLine4.nextInt();
		
		placeVec2 = Game.getPlaceVec2();
		
		this.currentPlaceChar = Place.getPlaceByID(cPlace);
		
		cID = fileIn.nextInt();
		cName = (fileIn.nextLine()).trim();
		
		//Assigning the Random places for the Non-Playing Character.
		if(cPlace == 0)
		{
			int rendomNum = new Random().nextInt(placeVec2.size());
			rendomNum = placeVec2.get(rendomNum).getRoomID();
			cPlace = rendomNum;
			this.currentPlaceChar = Place.getPlaceByID(cPlace);
		}
		
		nDisc = fileIn.nextInt();
		
		for(int b=0; b<nDisc; b++)
		{
			trimmed2=CleanLineScanner.getCleanLine(fileIn);
			Scanner temp=new Scanner(trimmed2);
			cDisc = cDisc + "\n" + temp.nextLine();
		}
		
		System.out.println("Please Select the Interface you want to Play with :=> ");
		
		Scanner numIn = new Scanner(System.in);
		int numberIn = numIn.nextInt();
		
		IO_Obj = new IO();
		IO_Obj.select(numberIn);
		
		
		charVec.add(this);
		charHash.put(cID, this);
		currentPlaceChar.addPlaceCharVec(this);
	}
	
	
	//Some getter functions to help printing the details of the appropriate character.
	public String getCharName()
	{
		return this.cName;
	}
	
	public String getcDisc()
	{
		return this.cDisc;
	}
	
	public int getcID()
	{
		return this.cID;
	}
	public String getcharType()
	{
		return this.charType;
	}
	//Make move FUnction this is where the magic happens....
	public void makeMove()
	{
		String playerInput="";
		boolean flag=false;
		
		//@SuppressWarnings("resource");
		//Scanner input= new Scanner(System.in);
		
		//System.out.println("");

			flag=false;
			//printChar();
			//System.out.println("You are in " + currentPlaceChar.name() + ".");
			
			IO_Obj.display("Enter your Choice =:> ");
	//		System.out.println("Enter your Choice =:> ");
			//playerInput=input.nextLine();
			playerInput = IO_Obj.getLine();
			
			//IO_Obj.display
			if(playerInput.equals("EXIT") || playerInput.equals("QUIT")||
					playerInput.equals("exit") || playerInput.equals("quit")||
					playerInput.equals("Exit") || playerInput.equals("Quit"))
			{
				
				//System.out.println("Thanks For Playing ... Hope to See you soon.");
				IO_Obj.display("Thanks For Playing ... Hope to See you soon.");
				//ExitCounter++;
				
				//if(ExitCounter == charVec.size())
				//{
					System.exit(0);
				//}
				//break;
			}
			if(playerInput.equals("LOOK")||playerInput.equals("look")||playerInput.equals("Look"))
			{
				flag=true;
				currentPlaceChar.print(IO_Obj);
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
				inputPart1 = playerInput.substring( 0 , playerInput.indexOf(" "));
				inputPart2 = playerInput.substring( playerInput.indexOf(" ")+1 , playerInput.length());	
				
				if(inputPart1.equalsIgnoreCase("GET"))
				{
					//Game.getArtifect(inputPart2);
					Artifact getArti = currentPlaceChar.placeArtiPlay(inputPart2);
					if ( getArti!= null)
					{
						Game.artiHMap2.put(inputPart2, getArti);
						//System.out.println ("Now...Trasfering '" + inputPart2 +"' in to the player's Inventory...\n\n");
						IO_Obj.display ("Now...Trasfering '" + inputPart2 +"' in to the player's Inventory...\n\n");
						Game.artiNum++;   
					}
					else
					{
						//System.out.println ("Nothing is added in this player's possesionss....");
						IO_Obj.display ("Nothing is added in this player's possesionss....");
					}
				}
				if(inputPart1.equalsIgnoreCase("DROP"))
				{
					//Game.dropArtifact(inputPart2);
					if ( Game.artiHMap2.containsKey(inputPart2))
					{
						//System.out.println ("Now...Dropping the '" + inputPart2 +"' from the player's bag...\n\n");
						IO_Obj.display ("Now...Dropping the '" + inputPart2 +"' from the player's bag...\n\n");
						Artifact dropArti = Game.artiHMap2.get(inputPart2);
						currentPlaceChar.getFromPlayer (dropArti, inputPart2);
						Game.artiHMap2.remove(inputPart2);
						Game.artiNum--;  
					}
					else
					{
						//System.out.println ("This '" + inputPart2 +"', you are trying to drop is not in the player's Inventory...");
						IO_Obj.display ("This '" + inputPart2 +"', you are trying to drop is not in the player's Inventory...");
					}
				}
				if(inputPart1.equalsIgnoreCase("USE"))
				{
					//Game.useArtifact(inputPart2);
					if ( Game.artiHMap2.containsKey(inputPart2))
					{
						Game.artiHMap2.get(inputPart2).use(this, currentPlaceChar);
					}
					else
					{
						//System.out.println ("This '" + inputPart2 +"', you are trying to use is not in the player's Inventory...");
						IO_Obj.display ("This '" + inputPart2 +"', you are trying to use is not in the player's Inventory...");
					}	
				}
				
			}
			
			//Probable Enhancement: checks for most of the user variations. 
			if(Direction.DirType.north.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				//To change the current place as player moves, as well as to follow the direction.
				//currentPlaceChar = (Place.getPlaceByID(this.cPlace)).followDirection("N");
				//System.out.println("You are in before " + this.currentPlaceChar.name() + ".");
				currentPlaceChar = currentPlaceChar.followDirection("N");
				currentPlaceChar.addPlaceCharVec(this);
				//IO_Obj.display("Enter your Choice =:> ");
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + this.currentPlaceChar.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations.
			if(Direction.DirType.south.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar = (Place.getPlaceByID(this.cPlace)).followDirection("S");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations.
			if(Direction.DirType.east.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				//currentPlaceChar=(Place.getPlaceByID(this.cPlace)).followDirection("E");
				//System.out.println("You are in before " + this.currentPlaceChar.name() + ".");
				currentPlaceChar = currentPlaceChar.followDirection("E");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + this.currentPlaceChar.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations.
			if(Direction.DirType.west.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar= currentPlaceChar.followDirection("W");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations. 
			if(Direction.DirType.up.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("U");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			
			//Probable Enhancement: checks for most of the user variations. 
			if(Direction.DirType.down.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("D");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			
			if(Direction.DirType.northNorthEast.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("NNE");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			
			if(Direction.DirType.eastNorthEast.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("ENE");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			if(Direction.DirType.northNorthWest.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("NNW");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			if(Direction.DirType.westNorthWest.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("WNW");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			if(Direction.DirType.southSouthWest.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("SSW");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			if(Direction.DirType.westSouthWest.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("WSW");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			if(Direction.DirType.southSouthEast.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("SSE");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			if(Direction.DirType.eastSouthEast.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("ESE");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			if(Direction.DirType.northEast.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("NE");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			if(Direction.DirType.southEast.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("SE");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			if(Direction.DirType.northWest.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("NW");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			if(Direction.DirType.southWest.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("SW");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			if(Direction.DirType.none.match(playerInput))
			{
				flag=true;
				currentPlaceChar.removePlaceCharVec(this);
				currentPlaceChar=currentPlaceChar.followDirection("NONE");
				currentPlaceChar.addPlaceCharVec(this);
				System.out.println("You are in " + currentPlaceChar.name() + ".");
				IO_Obj.display("You are in " + currentPlaceChar.name() + ".");
			}
			if(playerInput.equalsIgnoreCase("INVENTORY") || playerInput.equalsIgnoreCase("INVE"))
			{
				flag=true;
				//System.out.println ( (this.cName) + "'s Inventory information:"+"\n");
				IO_Obj.display ( (this.cName) + "'s Inventory information:"+"\n");
				//for loop to print the inventory of the player.
				for( HashMap.Entry <String, Artifact> getKey :  Game.artiHMap2.entrySet()) 
				{
					  String key = getKey.getKey();
					  Artifact inventory = getKey.getValue();
					  
//					  System.out.println("----------------------------------------------------------");
//					  System.out.println("|    Name of the Artifact : " +  inventory.name() +"      ");
//					  System.out.println("|    Size of the Artifact : " +   inventory.size()+"      ");
//					  System.out.println("|    Value of the Artifact: " +   inventory.value()+"     ");
//					  System.out.println("|    Discription          : " + inventory.artiDesc+"      ");
//					  System.out.println("----------------------------------------------------------");
					  
					  IO_Obj.display("----------------------------------------------------------");
					  IO_Obj.display("|    Name of the Artifact : " +  inventory.name() +"      ");
					  IO_Obj.display("|    Size of the Artifact : " +   inventory.size()+"      ");
					  IO_Obj.display("|    Value of the Artifact: " +   inventory.value()+"     ");
					  IO_Obj.display("|    Discription          : " + inventory.artiDesc+"      ");
					  IO_Obj.display("----------------------------------------------------------");
				}
				
				System.out.println ( "Total Artifacts with the Player : " + Game.artiNum );
				System.out.println("----------------------------------------------------------"+"\n");
				
				IO_Obj.display ( "Total Artifacts with the Player : " + Game.artiNum );
				IO_Obj.display("----------------------------------------------------------"+"\n");
			}
			
			//Checks to see if you have reached the EXIT place or not.
			if(currentPlaceChar.getRoomID() == 1)
			{
				flag = true;
				System.out.println("YAY! You found it...Well Done.");
				IO_Obj.display("YAY! You found it...Well Done.");
			}
			if(currentPlaceChar.getRoomID() == 0)
			{
				flag = true;
				System.out.println("Boom ! you are Stuck here forever....\n");
				IO_Obj.display("Boom ! you are Stuck here forever....\n");
			}
			
			//For the error message if user types something other than expected input.
			if(flag==false)
			{
				System.out.println("Not a Valid command, Please Try again.");
				IO_Obj.display("Not a Valid command, Please Try again.");
			}
	}//End of the play() function.
	
	public static Character getCharacterByID(int cid)
	{
		return charHash.get(cid);
	}
	
	//Print Character Details for debugging purposes... 
	//----------------------------------------------------------------------
	public void printChar()
	{
		System.out.println("Here are all the Characters : ");
		for (Character S: charVec)
		{
			System.out.println("The Name of the Character : " + S.cName);
			System.out.println("The Discription is : " + S.cDisc);
		}
		for (Artifact A: charArti)
		{
			System.out.println("The Name of the Character Artifact is : " + A.artiName);
			System.out.println("The Artifact Discription is : " + A.artiDesc);
		}
	}

}
