import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class GUI_Jay implements UserInterface, ActionListener
{
	
	private JFrame jayframe;
    private JTextArea area;
    private static JTextArea getArea;
    private static JTextArea useArea;
    private static JTextArea dropArea;
    private String universalButton;
    private boolean stopScreen;
    private Panel patel;
    private Panel patel1;
    private Panel patel2;
    private JScrollPane scroll;
    
	public GUI_Jay()
	{
		jayframe = new JFrame();
		jayframe.setSize(1000, 1000);
		jayframe.setTitle("Jay's Interface");
		jayframe.setVisible(true);
		jayframe.getContentPane().setBackground(Color.orange);
		jayframe.setDefaultCloseOperation(jayframe.EXIT_ON_CLOSE);
		//jayframe.setForeground(Color.red);
		stopScreen = false;
		
		
		//jayframe.setLayout ( new BoxLayout (patel, BoxLayout.PAGE_AXIS));
		patel = new Panel();//(new GridLayout(5,2,15,5));
		patel.setSize(100, 200);
		
		patel1 = new Panel();//(new GridLayout(2,2,5,5));
		patel2 = new Panel();
		
		jayframe.getContentPane().setLayout ( new FlowLayout(FlowLayout.CENTER,100,150));
		//jayframe.getContentPane().setLayout ( new GridLayout(2,2));
		jayframe.getContentPane().add(patel).setBackground(Color.cyan);
		jayframe.getContentPane().add(patel1).setBackground(Color.cyan);
		jayframe.getContentPane().add(patel2).setBackground(Color.cyan);
		
//		area = new JTextArea();
//		area.setBounds(300, 300, 100, 200);
//		//area.setLayout(new GridLayout(2,2,5,5));
//		//area.setLineWrap(true);
//		area.setFont(area.getFont().deriveFont(16f));
//		scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		//area.add(scroll);
//		//scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		scroll.setBounds(3, 3, 400, 400);
//		scroll.setVisible(true);
//		jayframe.getContentPane().add(scroll);
		
		//jayframe.setLayout(new BorderLayout());
		// Input
		JButton j1;
		JButton j2;
		JButton j3;
		JButton j4;
		JButton j5;
		JButton j6;
		JButton j7;
		JButton j8;
		JButton j9;
		JButton j10;
		JButton j11;
		JButton j12;
		JButton j13;
		JButton j14;
		JButton j15;
		JButton j16;
		JButton j17;
		JButton j18;
		JButton j19;
		JButton j20;
		JButton j21;
		JButton j22;
		JButton j23;
		JButton j24;
		JButton j25;
		
		
		j1 = new JButton ("NORTH");
		j1.setSize(100, 100);
		j1.addActionListener(this);
		jayframe.add(j1);
		patel.add(j1);
		
		
		j2 = new JButton ("SOUTH");
		j2.setSize(200, 200);
		j2.addActionListener(this);
		jayframe.add(j2);
		patel.add(j2);
		
		j3 = new JButton ("EAST");
		j3.setSize(200, 200);
		j3.addActionListener(this);
		jayframe.add(j3);
		patel.add(j3);
		
		j4 = new JButton ("WEST");
		j4.setSize(200, 200);
		j4.addActionListener(this);
		jayframe.add(j4);
		patel.add(j4);
		
		j5 = new JButton ("UP");
		j5.setSize(200, 200);
		j5.addActionListener(this);
		jayframe.add(j5);
		patel.add(j5);
		
		j6 = new JButton ("DOWN");
		j6.setSize(200, 200);
		j6.addActionListener(this);
		jayframe.add(j6);
		patel.add(j6);
		
		j7 = new JButton ("SW");
		j7.setSize(100, 100);
		j7.addActionListener(this);
		jayframe.add(j7);
		patel.add(j7);
		
		j8 = new JButton ("SE");
		j8.setSize(200, 200);
		j8.addActionListener(this);
		jayframe.add(j8);
		patel.add(j8);
		
		j9 = new JButton ("NE");
		j9.setSize(200, 200);
		j9.addActionListener(this);
		jayframe.add(j9);
		patel.add(j9);
		
		j10 = new JButton ("NW");
		j10.setSize(200, 200);
		j10.addActionListener(this);
		jayframe.add(j10);
		patel.add(j10);
		
		j11 = new JButton ("ESE");
		j11.setSize(200, 200);
		j11.addActionListener(this);
		jayframe.add(j11);
		patel.add(j11);
		
		j12 = new JButton ("SSE");
		j12.setSize(200, 200);
		j12.addActionListener(this);
		jayframe.add(j12);
		patel.add(j12);
		
		j13 = new JButton ("WNW");
		j13.setSize(100, 100);
		j13.addActionListener(this);
		jayframe.add(j13);
		patel.add(j13);
		
		j14 = new JButton ("SSW");
		j14.setSize(200, 200);
		j14.addActionListener(this);
		jayframe.add(j14);
		patel.add(j14);
		
		j15 = new JButton ("ENE");
		j15.setSize(200, 200);
		j15.addActionListener(this);
		jayframe.add(j15);
		patel.add(j15);
		
		j16 = new JButton ("WSW");
		j16.setSize(200, 200);
		j16.addActionListener(this);
		jayframe.add(j16);
		patel.add(j16);
		
		j17 = new JButton ("NNW");
		j17.setSize(200, 200);
		j17.addActionListener(this);
		jayframe.add(j17);
		patel.add(j17);
		
		j18 = new JButton ("NNE");
		j18.setSize(200, 200);
		j18.addActionListener(this);
		jayframe.add(j18);
		patel.add(j18);
		
		j19 = new JButton ("NONE");
		j19.setSize(200, 200);
		j19.addActionListener(this);
		jayframe.add(j19);
		patel.add(j19);
		
		j20 = new JButton ("EXIT");
		j20.setSize(200, 200);
		j20.addActionListener(this);
		jayframe.add(j20);
		patel1.add(j20);
		
		j21 = new JButton ("LOOK");
		j21.setSize(200, 200);
		j21.addActionListener(this);
		jayframe.add(j21);
		patel1.add(j21);
		
		j22 = new JButton ("INVENTORY");
		j22.setSize(200, 200);
		j22.addActionListener(this);
		jayframe.add(j22);
		patel1.add(j22);
		
		j23 = new JButton ("GET");
		j23.setSize(200, 200);
		j23.addActionListener(this);
		jayframe.add(j23);
		patel2.add(j23);
		
		j24 = new JButton ("USE");
		j24.doLayout();
		j24.setSize(200, 200);
		j24.addActionListener(this);
		jayframe.add(j24);
		patel2.add(j24);
		
		//useArea = new JTextArea (5,5);
		//jayframe.add(useArea);
		
		j25 = new JButton ("DROP");
		j25.setSize(200, 200);
		j25.addActionListener(this);
		jayframe.add(j25);
		patel2.add(j25);
		
		getArea = new JTextArea (2,5);
		jayframe.add(getArea);
		patel2.add(getArea);
		
		//dropArea = new JTextArea (5,5);
		//jayframe.add(dropArea);
		
		
		// Output
		//jayframe.add(patel);
		//area = new JTextArea ( 50, 80);
		
		area = new JTextArea();
		area.setSize(500, 500);
		area.setBounds(300, 300, 500, 500);
		//area.setLayout(new GridLayout(2,2,5,5));
		//area.setLineWrap(true);
		area.setFont(area.getFont().deriveFont(16f));
		scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(400, 400));
		//area.add(scroll);
		//scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(300, 300, 400, 400);
		scroll.setVisible(true);
		jayframe.getContentPane().add(scroll);
		
		//jayframe.add(area);	
		
	}
	
	

	@Override
	public void display(String toDisplay) 
	{
		// TODO Auto-generated method stub
		
		area.append(toDisplay+"\n");
		
	}

	@Override
	public String getLine() 
	{
		// TODO Auto-generated method stub
		while(true)
		{
			System.out.print("");
			if(stopScreen)
			{
				System.out.print("");
				stopScreen = false;
				return universalButton;
			}
		}
	}



	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		String buttonName = arg0.getActionCommand();
		String commandText = null;
		if("GET".equalsIgnoreCase(buttonName) || "USE".equalsIgnoreCase(buttonName) || "DROP".equalsIgnoreCase(buttonName))
		{
			commandText = buttonName + " " + getArea.getText();
			universalButton = commandText;
			System.out.println(universalButton);
			stopScreen = true;
		}
		else
		{
			//System.out.println(buttonName);
			universalButton = buttonName;
			System.out.println(universalButton);
			
			stopScreen = true;
		}
		
	}

}
