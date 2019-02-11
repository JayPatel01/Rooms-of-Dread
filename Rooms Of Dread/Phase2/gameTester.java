//gameTester Class for the game Testing...
//Name: Jay V Patel
//ACCC : jpate14
//netID: jpate225


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class gameTester {

	//Name: Jay V. Patel
	//NetID: jpate225
	//CS342 Project 2.
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.out.println("Name: Jay V. Patel");
		
		//providing a file path to open the file and access it accordingly...
		//NOTE: this will not work until you put the appropriate path where the file exists.
		File file = new File("mystic.txt");
		Scanner scan=new Scanner(file);
		Game game = new Game(scan);
		
		//playing the game.
		game.play();
		
	}

}
