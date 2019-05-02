import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GraphicalHammingDistanceFrame extends JFrame
{
	private static final int FRAME_WIDTH = 525;
	private static final int FRAME_HEIGHT = 530;
	private String fileName = "./Mesonet.txt";
	JPanel originalPanel = new JPanel ();
	JPanel originalPanelOne = new JPanel ();
	JPanel originalPanelTwo = new JPanel();
	JPanel creativePanel = new JPanel ();
	
	
	JLabel hdLabel = new JLabel("Enter Hamming Dist:");
	JTextField hdField = new JTextField("2");
	JSlider hdSlider = new JSlider(1, 4, 2);
	JButton showStationButton = new JButton("Show Station");
	JTextArea stationResults = new JTextArea();
	JScrollPane sp = new JScrollPane(stationResults);
	
	//------------------------------------------------------
	// This are the components used in original Panel Two
	//------------------------------------------------------
	JComboBox dropDownBox;
	
	ArrayList<String> dropDownContents = new ArrayList <String>();
	
	JLabel comparisonLabel = new JLabel("Compare with:");
	JButton calculateHD = new JButton("Calculate HD");
		
	JButton addStation = new JButton("Add Station");
	JTextField stationField = new JTextField();
	
	JLabel distanceLabel0 = new JLabel("Distance 0");
	JLabel distanceLabel1 = new JLabel("Distance 1");
	JLabel distanceLabel2 = new JLabel("Distance 2");
	JLabel distanceLabel3 = new JLabel("Distance 3");
	JLabel distanceLabel4 = new JLabel("Distance 4"); 
	
	JTextField distField0 = new JTextField();
	JTextField distField1 = new JTextField();
	JTextField distField2 = new JTextField();
	JTextField distField3 = new JTextField();
	JTextField distField4 = new JTextField();
	

	
	//--------------------------------------------------
	// These are the components for the creative panel
	//--------------------------------------------------
	
	JButton generateRandom = new JButton("Generate Station at Random");
	JTextField randomStationID = new JTextField("",5);
	JButton calculationButton = new JButton("Calculate");
	GridBagConstraints layoutSetUp = null;
	
	public ArrayList<String> getAllStations() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		// As long as the file has more lines, ...
		while(br.ready())
		{
			String str = br.readLine().substring(0, 4);
			dropDownContents.add(str);
		}
		
		br.close();
		return dropDownContents;
	}

	
	
	//---------------------------------------------------
	public GraphicalHammingDistanceFrame() {
		super("Hamming Distance Calculator");
		
		this.setSize(FRAME_HEIGHT, FRAME_WIDTH);
		this.setLayout(new GridLayout(0, 2));
		int o = 0;
		
		try {
			o = getAllStations().size();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String[] dc = new String[o];
		for(int i = 0; i< dc.length; i++)
			try {
				dc[i] = getAllStations().get(i);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		dropDownBox = new JComboBox<String>(dc) ;
		
		//Setting up of Original Panel 

		hdField.setEditable(false);
		hdSlider.setMajorTickSpacing(1);
		hdSlider.setPaintLabels(true);
		hdSlider.setPaintTicks(true);
		stationResults.setEditable(false);
		stationResults.setColumns(10);
		stationResults.setRows(10);
	
		// Components used to set up Original Panel Two
		distField0.setEditable(false);
		distField1.setEditable(false);
		distField2.setEditable(false);
		distField3.setEditable(false);
		distField4.setEditable(false);
		
		originalPanelOne.setLayout(new GridBagLayout());
		
		// Filling out of "Enter Distance" Button
		layoutSetUp = new GridBagConstraints();
		layoutSetUp.weighty = 1;
		layoutSetUp.gridx = 0;
		layoutSetUp.gridy = 0;
		originalPanelOne.add(hdLabel, layoutSetUp);
		
		layoutSetUp = new GridBagConstraints();
		layoutSetUp.weighty = 1;
		layoutSetUp.gridx = 1;
		layoutSetUp.gridy = 0;
		originalPanelOne.add(hdField , layoutSetUp);
		
		layoutSetUp.gridx = 1;
		layoutSetUp.fill = GridBagConstraints.HORIZONTAL;
		originalPanelOne.add(distField0, layoutSetUp);
		
		
		// "Slider"
		layoutSetUp = new GridBagConstraints();
		layoutSetUp.gridx = 0;
		layoutSetUp.gridy = 1;
		layoutSetUp.gridwidth = 4;
		originalPanelOne.add(hdSlider, layoutSetUp);
		
		// "Show Station" Button and Field
		layoutSetUp = new GridBagConstraints();
		layoutSetUp.gridy = 2;
		layoutSetUp.gridx = 2;
		originalPanelOne.add(showStationButton, layoutSetUp);
		
		layoutSetUp.gridy = 3;
		layoutSetUp.gridwidth = 2;
		layoutSetUp.fill = GridBagConstraints.HORIZONTAL;
		originalPanelOne.add(sp,layoutSetUp);
		//Original Panel Two Components
		originalPanelTwo.setLayout(new GridBagLayout());
		
		// Calculate and Compare Button & Drop-Down Box
		layoutSetUp = new GridBagConstraints();
		layoutSetUp.anchor = GridBagConstraints.LINE_START;
			
			layoutSetUp.gridx = 0;
			layoutSetUp.gridy = 0;
			originalPanelTwo.add(comparisonLabel, layoutSetUp);
		

			layoutSetUp = new GridBagConstraints();
			setupDropDownBox();
			layoutSetUp.gridx = 1;
			layoutSetUp.gridy = 0;
			originalPanelTwo.add(dropDownBox, layoutSetUp);
			
			layoutSetUp.gridx = 0;
			layoutSetUp.gridy = 1;
			originalPanelTwo.add(calculateHD, layoutSetUp);
			
			// Distance labels and fields
			layoutSetUp.gridx = 0;
			layoutSetUp.gridy = 2;
			originalPanelTwo.add(distanceLabel0, layoutSetUp);
			
			layoutSetUp.gridx = 1;
			//layoutSetUp.gridy = 1;
			layoutSetUp.fill = GridBagConstraints.HORIZONTAL;
			originalPanelTwo.add(distField0, layoutSetUp);
			
			layoutSetUp = new GridBagConstraints();
			layoutSetUp.gridx = 0;
			layoutSetUp.gridy = 3;
			originalPanelTwo.add(distanceLabel1, layoutSetUp);
			
			layoutSetUp = new GridBagConstraints();
			layoutSetUp.gridx = 1;
			layoutSetUp.fill = GridBagConstraints.HORIZONTAL;
			originalPanelTwo.add(distField1, layoutSetUp);
			
			layoutSetUp = new GridBagConstraints();
			layoutSetUp.gridx = 0;
			layoutSetUp.gridy = 4;
			originalPanelTwo.add(distanceLabel2, layoutSetUp);
			
			layoutSetUp.gridx = 1;
			layoutSetUp.fill = GridBagConstraints.HORIZONTAL;
			originalPanelTwo.add(distField2, layoutSetUp);
			
			layoutSetUp = new GridBagConstraints();
			layoutSetUp.gridx = 0;
			layoutSetUp.gridy = 5;
			originalPanelTwo.add(distanceLabel3, layoutSetUp);
			
			layoutSetUp.gridx = 1;
			layoutSetUp.fill = GridBagConstraints.HORIZONTAL;
			originalPanelTwo.add(distField3, layoutSetUp);
			
			layoutSetUp = new GridBagConstraints();
			layoutSetUp.gridx = 0;
			layoutSetUp.gridy = 6;
			originalPanelTwo.add(distanceLabel4, layoutSetUp);
			
			layoutSetUp.gridx = 1;
			layoutSetUp.fill = GridBagConstraints.HORIZONTAL;
			originalPanelTwo.add(distField4, layoutSetUp);
			
			// Add station button and field
			layoutSetUp = new GridBagConstraints();
			layoutSetUp.gridx = 0;
			layoutSetUp.gridy = 7;
			originalPanelTwo.add(addStation, layoutSetUp);
			
			layoutSetUp.gridx = 1;
			layoutSetUp.fill = GridBagConstraints.HORIZONTAL;
			originalPanelTwo.add(stationField, layoutSetUp);
			
			// Creative Panel components
			creativePanel.setLayout(new GridBagLayout());
			
			// "Generate random" button, random station ID field, and "Add & Calculate" button
			layoutSetUp = new GridBagConstraints();
			layoutSetUp.gridx = 0;
			layoutSetUp.gridy = 0;
			layoutSetUp.fill = GridBagConstraints.CENTER;
			creativePanel.add(generateRandom, layoutSetUp);
			
			randomStationID.setEditable(false);
			layoutSetUp.gridx = 1;
			layoutSetUp.fill = GridBagConstraints.CENTER;
			creativePanel.add(randomStationID, layoutSetUp);
			
			calculationButton.setBackground(Color.PINK);
			layoutSetUp.gridx = 0;
			layoutSetUp.gridy = 2;
			layoutSetUp.gridwidth = 2;
			creativePanel.add(calculationButton, layoutSetUp);
			
			// Child panels added to Parent Panel
			originalPanel.setLayout(new GridBagLayout());
	        originalPanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
			
	        layoutSetUp = new GridBagConstraints();
	        layoutSetUp.fill = GridBagConstraints.VERTICAL;
	        layoutSetUp.gridx = 0;
	        layoutSetUp.gridy = 0;
			
			originalPanel.add(originalPanelOne, layoutSetUp);
			
			layoutSetUp.gridy = 1;
			originalPanel.add(originalPanelTwo, layoutSetUp);
			
			// Panels added to frame
			this.add(originalPanel);
			this.add(creativePanel);
			
			// This permits to drag the slider
			hdSlider.addChangeListener((l) -> {
				int value = hdSlider.getValue();
				hdField .setText(Integer.toString(value));
	});
			//This generates a list of Station ID's with a specific hamming distance
			showStationButton.addActionListener((e) -> {
				
				ArrayList<String> stations = getStationList();
		
				String toPrint = "";
				for(int i = 0; i < stations.size(); ++i)
				{
					toPrint += stations.get(i) + "\n";
				}
				stationResults.setText(toPrint);
				
				// Starts the scroll bar at the top
				stationResults.setCaretPosition(0);
			});
			
			addStation.addActionListener((e) -> {
				String stationID = stationField.getText();
				if(stationID.length() == 4 && !dropDownContents.contains(stationID))
				{
					addNewItem(stationID);
					stationField.setText("");
				}
			});
			
			calculateHD.addActionListener((e) -> {
				//This action saves the count of the words
				int[] hammingNodes = getHammingDistance();
				distField0.setText(Integer.toString(hammingNodes[0]));
				distField1.setText(Integer.toString(hammingNodes[1]));
				distField2.setText(Integer.toString(hammingNodes[2]));
				distField3.setText(Integer.toString(hammingNodes[3]));
				distField4.setText(Integer.toString(hammingNodes[4]));
			});
			
			generateRandom.addActionListener((e) -> {
				String randomStation = generateRandomStation();
				randomStationID.setText(randomStation);
			});
			
			calculationButton.addActionListener((e) -> {
				// Adds station to the station list
				String stationID = randomStationID.getText();
				if(stationID.length() == 4 && !dropDownContents.contains(stationID))
				{
					addNewItem(stationID);
					stationField.setText("");
				}
				
				dropDownBox.setSelectedItem(stationID);
				
				//Stores count of words in the text file
				int[] hammingNodes = getHammingDistance();
				distField0.setText(Integer.toString(hammingNodes[0]));
				distField1.setText(Integer.toString(hammingNodes[1]));
				distField2.setText(Integer.toString(hammingNodes[2]));
				distField3.setText(Integer.toString(hammingNodes[3]));
				distField4.setText(Integer.toString(hammingNodes[4]));
			});
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);
		}
		
		//Used to generate an int array of the number of stations in the list
		public int[] getHammingDistance()
		{
		HammingDistance hd = new HammingDistance();
		String activeStation = (String)dropDownBox.getSelectedItem();
		int[] results = new int[5];
		try {
			results = hd.checkAgainstAllWords(activeStation);
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return results;
	}
		//This generates a list of station IDs by creating a HammingDistance object by selecting words from JComboBox
		public ArrayList<String> getStationList()
		{
			HammingDistance hd = new HammingDistance();
			
			int target = Integer.parseInt(hdField.getText());
			String word = (String)dropDownBox.getSelectedItem();
			ArrayList<String> stations = new ArrayList<String>();
			
			try {
				stations = hd.getStationList(word, target);
			} 
			catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			return stations;
		}
		
		//This will add a new StationID to the list held in the JComboBox
		public void addNewItem(String stationID)
		{
			dropDownContents.add(stationID);
			Collections.sort(dropDownContents);
			dropDownBox.removeAllItems();
			
			for(String station: dropDownContents)
			{
				dropDownBox.addItem(station);
			}
		}
		public String generateRandomStation()
		{
			SelectedStation random = new SelectedStation();
			return random.provideSelectedStation();
		}
		private void setupDropDownBox()
		{
			HammingDistance hd = new HammingDistance();

			// Attempts to read-in stations from a file
			try {
				dropDownContents = hd.getAllStations();
				
				for (String station : dropDownContents)
				{
					dropDownBox.addItem(station);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public static void main(String[] args) {
			new GraphicalHammingDistanceFrame();
		}
}