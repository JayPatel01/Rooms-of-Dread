import java.util.Scanner;

public class textInterface implements UserInterface 
{

	public void display(String toDisplay) 
	{
		//System.out.println(" textinerface enter ");
		// TODO Auto-generated method stub
		System.out.println(toDisplay);
		
	}

	@Override
	public String getLine() 
	{
		// TODO Auto-generated method stub
		Scanner InputKeyboard = new Scanner(System.in);
		String getLine = InputKeyboard.nextLine();
		return getLine;
	}
	

}
