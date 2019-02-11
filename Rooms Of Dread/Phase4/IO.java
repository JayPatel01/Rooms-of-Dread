
public class IO implements UserInterface
{
	int textInter = 0;
	int GUI_Jay = 1;
	int GUI_Shivani = 2;
	int GUI_Ruchit = 3;
	private int temp = 0;
	UserInterface Obj;

	@Override
	public void display(String toDisplay) 
	{
		// TODO Auto-generated method stub
		//System.out.println(toDisplay);
		Obj.display(toDisplay);
		//System.out.println("After textInterface");
		
	}

	@Override
	public String getLine() 
	{
		// TODO Auto-generated method stub
		return Obj.getLine();
	}
	
	public void select ( int sel)
	{
		switch (sel)
		{
		
		case 0:
				//temp = textInter;
				//System.out.println("makingggg  ");
				Obj = new textInterface();
				break;
				//System.out.println("After textInterface");
		case 1:
				Obj = new GUI_Jay();
				break;
		
		}
		
	}

}
