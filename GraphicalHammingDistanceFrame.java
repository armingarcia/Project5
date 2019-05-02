import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

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
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 1800;
	
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
	JComboBox<String> dropDownBox = new JComboBox<String>();
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
	
	JButton selectRandomStation = new JButton("Select Random Station");
	JTextField randomStationID = new JTextField("",5);
	JButton calculationButton = new JButton("Calculate");
	GridBagConstraints layoutSetUp = null;
	
	//---------------------------------------------------
	public GraphicalHammingDistanceFrame() {
		super("Hamming Distance Calculator");
		this.setSize(FRAME_HEIGHT, FRAME_WIDTH);
		this.setLayout(new GridLayout(2, 1));
		
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
		layoutSetUp.gridx = 0;
		layoutSetUp.gridy = 0;
		originalPanelOne.add(distanceLabel0, layoutSetUp);
		
	}
}