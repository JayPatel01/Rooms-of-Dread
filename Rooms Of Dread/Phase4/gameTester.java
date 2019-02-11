//gameTester Class for the game Testing...


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class gameTester {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
		//providing a file path to open the file and access it accordingly...
		//NOTE: this will not work until you put the appropriate path where the file exists.
		//"C:\\Users\\Jay Patel\\Desktop\\mystic.txt"
		File file = new File("C:\\Users\\shiv9\\OneDrive\\Desktop\\mystic5.txt");
		Scanner scan=new Scanner(file);
		Game game = new Game(scan);
		
		//playing the game.
		game.playChar();
		
	}

}
