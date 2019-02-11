
public class gameTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Name: Jay V. Patel");
		
		//Creating a Game class object
		Game game=new Game("RoomPuzzle Game");
		
		//Creating  Place class object and initializing it using constructor.
		Place EH=new Place(12,"Enterance Hall","*You are standing in the entrance hall of the great six-room dungeon\\r\\n\" + \r\n" + 
				"				\"*There are doors to the east and north, and a stairway leading down\\r\\n\" + \r\n" + 
				"				\"*The main exit ( from the game ) is to the west ");
		
		//Adding created place to the Game class using Game object.
		game.addPlace(EH);
		
		Place PS=new Place(11,"Potions Storeroom","*This room has shelves full of bottles and jars\\r\\n\" + \r\n" + 
				"				\"*Some labels read \\\"Powdered bat's wings\\\" and \\\"Toad eyes\\\".\\r\\n\" + \r\n" + 
				"				\"*There is a door to the east, and a stairway leading up.");
		
		game.addPlace(PS);
		
		Place PL=new Place(21,"Potions Lab"," *There is a cauldron of thick green goop here, \\r\\n\" + \r\n" + 
				"				\"*bubbling slowly over a cool blue flame.\\r\\n\" + \r\n" + 
				"				\"*Doors lead to the west and east.");
		
		game.addPlace(PL);
		
		Place PE=new Place(22,"Pool of Enchantment"," *You are in a round room with a clear enchanting pool of water.\\r\\n\" + \r\n" + 
				"				\"*There are doors to the north and west.\\r\\n\" + \r\n" + 
				"				\"*There is a slide leading downwards to the floor below.");
		
		game.addPlace(PE);
		
		Place TS=new Place(23,"Treasure Storeroom"," *You have found a storeroom full of gold, jewels, and treasure!\\r\\n\" + \r\n" + 
				"				\"*There are doors to the north and south.");
		
		game.addPlace(TS);
		
		Place OL=new Place(13,"Ogre's Lair","*You have entered the Ogre's Lair!  Better leave before he wakes up . . .\\r\\n\" + \r\n" + 
				"				\"*There are doors to the south and the east");
		
		game.addPlace(OL);
		
		Place ET=new Place(00,"EXIT Place","Congratulations! You have successfully Exited the room Puzzle");
		
		game.addPlace(ET);
		
		Place NW=new Place(99,"Knowhere","Sorry You cannot go to the point beyond this...");
		
		game.addPlace(NW);
		
		//Creating the direction class objects for the each possible direction from each rooms.
		Direction EHtoET=new Direction(12,EH,ET,"W");
		Direction EHtoOL=new Direction(12,EH,OL,"N");
		Direction EHtoPS=new Direction(12,EH,PS,"D");
		Direction EHtoPE=new Direction(12,EH,PE,"E");
		
		//adding the directions to the place objects.
		EH.addDirection(EHtoET);
		EH.addDirection(EHtoOL);
		EH.addDirection(EHtoPS);
		EH.addDirection(EHtoPE);
		
		Direction OLtoTS=new Direction(13,OL,TS,"E");
		Direction OLtoEH=new Direction(13,OL,EH,"S");
		
		OL.addDirection(OLtoTS);
		OL.addDirection(OLtoEH);
		
		Direction TStoPE=new Direction(23,TS,PE,"S");
		Direction TStoOL=new Direction(23,TS,OL,"N");
		
		TS.addDirection(TStoPE);
		TS.addDirection(TStoOL);
		
		Direction PEtoPL=new Direction(22,PE,PL,"D");
		Direction PEtoTS=new Direction(22,PE,TS,"N");
		Direction PEtoEH=new Direction(22,PE,EH,"W");
		
		//using the lock() function from the direction class to lock the direction.
		PEtoTS.lock();
		
		PE.addDirection(PEtoPL);
		PE.addDirection(PEtoTS);
		PE.addDirection(PEtoEH);
		
		Direction PLtoNW=new Direction(21,PL,NW,"E");
		Direction PLtoPS=new Direction(21,PL,PS,"W");
		
		PLtoNW.lock();
		
		PL.addDirection(PLtoNW);
		PL.addDirection(PLtoPS);
		
		Direction PStoEH=new Direction(11,PS,EH,"U");
		Direction PStoPL=new Direction(11,PS,PL,"E");
		
		PStoPL.lock();
		
		PS.addDirection(PStoEH);
		PS.addDirection(PStoPL);
		
		//Calling the game play() function to play the game.
		game.play();
		
	}

}
