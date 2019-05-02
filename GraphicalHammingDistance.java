import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class HammingDistanceFrame extends JFrame implements  ChangeListener, ActionListener {
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 1800;
	private ArrayList<String> Words=new ArrayList();


	/**
	 * Width and height for the panel. Width matches the enclosing frame.
	 */
	private static final int PANEL_WIDTH = FRAME_WIDTH;
	private static final int PANEL_HEIGHT = 900;
	private JButton Show;
	private JButton Calculate;
	private JButton Add;
	private JLabel Compare;
	private JLabel Enter;
	private JLabel d0;
	private JLabel d1;
	private JLabel d2;
	private JLabel d3;
	private JLabel d4;
	private JTextField EnterDistance;
	private JTextField Dist1;
	private JTextField Dist2;
	private JTextField Dist3;
	private JTextField Dist4;
	private JTextField Dist0;
	private JTextArea AddStation;
	private JTextArea Display;
	private JSlider Distance;
	private JComboBox Menu;

	public HammingDistanceFrame() throws IOException
	{
		int minSlider=1;
		int maxSlider=4;
		int init=2;

		Distance = new JSlider(minSlider, maxSlider, init);
	Distance.addChangeListener(this); // Use HeightConverter's stateChanged()
		Distance.setMajorTickSpacing(1);	
		Distance.setPaintTicks(true);
		Distance.setPaintLabels(true);

		setTitle("Hamming Distance");
		//label setup
		Enter = new JLabel("Enter Hamming Dist:");
		Compare=new JLabel("Compare With:");
		d0=new JLabel("Distance0");
		d1=new JLabel("Distance1");
		d2=new JLabel("Distance2");
		d3=new JLabel("Distance3");
		d4=new JLabel("Distance4");



		//Text box setup
		EnterDistance = new JTextField(10);
		EnterDistance.setEditable(true);
		

		Dist1=new JTextField(10);
		Dist1.setEditable(true);
		


		Dist2 =new JTextField(10);
		Dist2.setEditable(true);
		

		Dist3 =new JTextField(10);
		Dist3.setEditable(true);
		

		Dist0 =new JTextField(10);
		Dist0.setEditable(true);
		

		Dist4 =new JTextField(10);
		Dist4.setEditable(true);
		


		AddStation =new JTextArea(2,10);
		AddStation.setEditable(true);
		AddStation.setText("ZERO");
		AddStation.setBackground(Color.WHITE);

		Display =new JTextArea(10,20);
		JScrollPane scrollPane=new JScrollPane(Display);

		//Buttons setup
		Show = new JButton("Show Station");
		Show.addActionListener(this);

		Calculate = new JButton("Calculate HD");
		Calculate.addActionListener(this);

		Add = new JButton("Add Station");
		//Add.addActionListener(this);

		//Dropdown setup
		read("Mesonet.txt");
		Menu=new JComboBox(Words.toArray());



		setLayout(new GridBagLayout());
		GridBagConstraints layoutConst = null;

		JPanel panel1=new JPanel(new GridBagLayout());
		
		layoutConst = new GridBagConstraints();
	      layoutConst.insets = new Insets(10, 10, 1, 1);
	      layoutConst.anchor = GridBagConstraints.LINE_START;
	      layoutConst.gridx = 0;
	      layoutConst.gridy = 0;
	      layoutConst.gridwidth = 1;
	      panel1.add(Enter, layoutConst);
	      this.add(panel1);
	      
	      layoutConst = new GridBagConstraints();
	      layoutConst.insets = new Insets(10, 1, 1, 10);
	      layoutConst.fill = GridBagConstraints.HORIZONTAL;
	      layoutConst.gridx = 1;
	      layoutConst.gridy = 0;
	      layoutConst.gridwidth = 1;
	     panel1.add(EnterDistance, layoutConst);
	     this.add(panel1);
	     
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(1, 10, 10, 10);
	     layoutConst.fill = GridBagConstraints.HORIZONTAL;
	     layoutConst.gridx = 0;
	     layoutConst.gridy = 1;
	     layoutConst.gridwidth = 3;
	     panel1.add(Distance, layoutConst);
	     this.add(panel1);
	     
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(10, 10, 10, 5);
	     layoutConst.anchor = GridBagConstraints.LINE_START;
	     layoutConst.gridx = 0;
	     layoutConst.gridy = 2;
	     layoutConst.gridwidth = 1;
	     panel1.add(Show, layoutConst);
	     this.add(panel1);
	     
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(10, 10, 1, 1);
	     layoutConst.anchor = GridBagConstraints.LINE_START;
	     layoutConst.gridx = 0;
	     layoutConst.gridy = 4;
	     layoutConst.gridwidth=20;
	     panel1.add(Display, layoutConst);
	     this.add(panel1);
	     
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(22,10,22,1);
	     layoutConst.anchor = GridBagConstraints.LINE_START;
	     layoutConst.gridx = 0;
	     layoutConst.gridy = 22;
	     layoutConst.gridwidth = 1;
	     panel1.add(Compare, layoutConst);
	     this.add(panel1);
	     
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(22,-10,22,1);
	     layoutConst.anchor = GridBagConstraints.LINE_START;
	     layoutConst.gridx = 1;
	     layoutConst.gridy = 22;
	     layoutConst.gridwidth = 1;
	     panel1.add(Menu, layoutConst);
	     this.add(panel1);
	     
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(10, 1, 10, 5);
	     layoutConst.anchor = GridBagConstraints.LINE_START;
	     layoutConst.gridx = 0;
	     layoutConst.gridy = 23;
	     layoutConst.gridwidth = 1;
	     panel1.add(Calculate, layoutConst);
	     this.add(panel1);
	     
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(10,1,1,1);
	     layoutConst.anchor = GridBagConstraints.LINE_START;
	     layoutConst.gridx = 0;
	     layoutConst.gridy = 24;
	     layoutConst.gridwidth = 1;
	     panel1.add(d0, layoutConst);
	     this.add(panel1);
	     
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(10,-20, 1, 10);
	     layoutConst.fill = GridBagConstraints.HORIZONTAL;
	     layoutConst.gridx = 1;
	     layoutConst.gridy = 24;
	     layoutConst.gridwidth = 1;
	     panel1.add(Dist0, layoutConst);
	     this.add(panel1);
	     
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(20,1,1,1);
	     layoutConst.anchor = GridBagConstraints.LINE_START;
	     layoutConst.gridx = 0;
	     layoutConst.gridy = 25;
	     layoutConst.gridwidth = 1;
	     panel1.add(d1, layoutConst);
	     this.add(panel1);
	     
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(20,-20, 1, 10);
	     layoutConst.fill = GridBagConstraints.HORIZONTAL;
	     layoutConst.gridx = 1;
	     layoutConst.gridy = 25;
	     layoutConst.gridwidth = 1;
	     panel1.add(Dist1, layoutConst);
	     this.add(panel1);
	     
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(20,1,1,1);
	     layoutConst.anchor = GridBagConstraints.LINE_START;
	     layoutConst.gridx = 0;
	     layoutConst.gridy = 26;
	     layoutConst.gridwidth = 1;
	     panel1.add(d2, layoutConst);
	     this.add(panel1);

	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(20,-20, 1, 10);
	     layoutConst.fill = GridBagConstraints.HORIZONTAL;
	     layoutConst.gridx = 1;
	     layoutConst.gridy = 26;
	     layoutConst.gridwidth = 1;
	     panel1.add(Dist2, layoutConst);
	     this.add(panel1);
	     
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(20,1,1,1);
	     layoutConst.anchor = GridBagConstraints.LINE_START;
	     layoutConst.gridx = 0;
	     layoutConst.gridy = 27;
	     layoutConst.gridwidth = 1;
	     panel1.add(d3, layoutConst);
	     this.add(panel1);

	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(20,-20, 1, 10);
	     layoutConst.fill = GridBagConstraints.HORIZONTAL;
	     layoutConst.gridx = 1;
	     layoutConst.gridy = 27;
	     layoutConst.gridwidth = 1;
	     panel1.add(Dist3, layoutConst);
	     this.add(panel1); 
	     
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(20,1,1,1);
	     layoutConst.anchor = GridBagConstraints.LINE_START;
	     layoutConst.gridx = 0;
	     layoutConst.gridy = 28;
	     layoutConst.gridwidth = 1;
	     panel1.add(d4, layoutConst);
	     this.add(panel1);

	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(20,-20, 1, 10);
	     layoutConst.fill = GridBagConstraints.HORIZONTAL;
	     layoutConst.gridx = 1;
	     layoutConst.gridy = 28;
	     layoutConst.gridwidth = 1;
	     panel1.add(Dist4, layoutConst);
	     this.add(panel1); 
	     
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(20, -20, 10, 10);
	     layoutConst.fill = GridBagConstraints.LINE_START;
	     layoutConst.gridx = 0;
	     layoutConst.gridy = 29;
	     layoutConst.gridwidth = 1;
	     panel1.add(Add, layoutConst);
	     this.add(panel1);
	      
	     layoutConst = new GridBagConstraints();
	     layoutConst.insets = new Insets(20,1,1,1);
	     layoutConst.anchor = GridBagConstraints.LINE_END;
	     layoutConst.gridx = 1;
	     layoutConst.gridy = 29;
	     layoutConst.gridwidth = 2;
	     panel1.add(AddStation, layoutConst);
	     this.add(panel1);

	     

this.setVisible(true);
this.setSize(FRAME_WIDTH, FRAME_HEIGHT);

	}
	public void stateChanged(ChangeEvent event) {
	      int sliderVal;            // Slider value (int)
	      String strSliderVal;      // Slider value (string)

	      // Get source of event 
	      JSlider sourceEvent = (JSlider) event.getSource();

	      if (sourceEvent == Distance) {
	         sliderVal = Distance.getValue();      // Get slider value
	         strSliderVal = Integer.toString(sliderVal); // Convert to int
	         EnterDistance.setText(strSliderVal);        // Update display
	      }
	}
	public int findDistance(String s, String s1)//WEST and BESS
	{
		int distance=0;
		for(int i=0;i<=3;i++)// loops through every character of the string
		{
			if(s.charAt(i)!=s1.charAt(i))	
				distance++; 
		}
		return distance;
	}
	
	public int[] numberNodes(String s)
	{   int distance;

	int count0=0, count1=0, count2=0, count3=0, count4=0; //4 possible distances

	for(int i=0;i<Words.size();i++)// looping through words in Mesonet.txt
	{ 
		distance=findDistance(Words.get(i), s);
		if(distance==0)
			count0++;
		else if(distance==1)
			count1++;// incrementing variable for station with word having a distance of one from the string given by the user
		else if(distance==2)
			count2++;
		else if(distance==3)
			count3++;
		else if(distance==4)
			count4++;
		else
		{

		}
	}
	int [] count=new int[] {count0,count1, count2,count3, count4};// array containing all four node counts
	return count;
	}

	/* Called when button is pressed. Converts height to cm. */
	   
	   
//Back End
	
	public void read(String fileName)throws IOException
	{
		BufferedReader br=new BufferedReader(new FileReader("Mesonet.txt"));
		String strg;
		
		strg=br.readLine();
		while(strg!=null)
		{
			Words.add(strg.substring(0,4));// Takes one word at a time and omits spaces
			strg=br.readLine();
			System.out.println(strg);// Reads mesonet.txt in
		}
		br.close();
	}
	public static void main(String [] args) throws IOException
	{
		HammingDistanceFrame obj=new HammingDistanceFrame();
		
		
		
	}
	String station = "";
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource()==Show)
		{
			String word;          // User defined height in feet
		      int Val=Distance.getValue();          // User defined height in inches
		            // Corresponding height in cm
		      
		      word = Menu.getSelectedItem().toString();  
		      try {
				read("Mesonet.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      for(int i=0;i<Words.size();i++)
		      {
		    	  if(findDistance(word,Words.get(i))==Val)
		    	  {
		    		 station = station + Words.get(i) + "\n";
		    	  }
		    	 
		      }
		      Display.setText(station);
		}
		if(event.getSource()==Calculate)
		{
			String word= Menu.getSelectedItem().toString();
			int[]distance=numberNodes(word);
			
			Dist0.setText(String.valueOf(distance[0]));
			Dist1.setText(String.valueOf(distance[1]));
			Dist2.setText(String.valueOf(distance[2]));
			Dist3.setText(String.valueOf(distance[3]));
			Dist4.setText(String.valueOf(distance[4]));
		}
		if(event.getSource()==Add)
		{
			if((DefaultComboBoxModel)(Menu).);

		}
	}

}
