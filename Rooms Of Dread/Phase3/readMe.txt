//ReadMe file

Game Logic:
1. I have made the game using the input of the file "Mystic_city_4.0.gdf"
2. Once you run the program, it will display user the name of the game, and the choices that user can enter.
3. If you type "look" on the very first turn you will see your current place and description with the Artifact information.
4. i have used Enum DirType{} so that Program accepts "North", "NORTH", "N", "North", "GO NORTH", etc. variations for all the directions.
5. Once user types the direction the program will follow it and check whether the input is valid or not, and
   direction is locked or unlocked.
6. Prints out the exception message when the direction is locked.
7. Descriptions of the important functions are in comment section at the beginning of the each function.
8. User has four new commands Get,Drop,Use,Inventory.
9. inventory prints out the Artifacts.

Enhancement:
1. It accepts variations of user inputs for 19 possible directions with Enum..
	For example, to go North the user can type,
	["GO N","GO NORTH","GO North","GO north",
		"Go North","Go north","NORTH","North",
		"north","N","n" ]  
		
2. Now the Game class does not have the play() mathod anymore.
3. there is no CurrentPalce in Game class...Each Characters have their own Current Places.
4. If you want to exit the game you have to exit from all the CHaracter game playing.
5. I have implemented the Player part of the program, There will be future enhancement of NPC, AI interface.