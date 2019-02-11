//ReadMe file

Game Logic:
1. I have made the game using the reference of the file "sixRooms.gdf"
2. Once you run the program, it will display user the name of the game, and the choices that user can enter.
3. If you type "look" on the very first turn you will see your current place and description.
4. Program accepts "North", "NORTH", "N", "Go North", "GO NORTH", etc. variations for all the directions i.e(N,W,S,E,Up,Down).
5. Once user types the direction the program will follow it and check whether the input is valid or not, and
   direction is locked or unlocked.
6. Prints out the exception message when the direction is locked.
7. Descriptions of the important functions are in comment section at the beginning of the each function.

Enhancement:
1. It accepts variations of user inputs for six directions.
	North, South, East, West, Up, down.
	For example, to go North the user can type,
	["GO N","GO NORTH","GO North","GO north",
		"Go North","Go north","NORTH","North",
		"north","N","n","Go N","Go n","go N","go n" ]  