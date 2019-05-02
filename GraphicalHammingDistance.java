import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.BufferedReader;

public class GraphicalHammingDistance extends JFrame

public class HammingDistanceFrame extends JFrame implements  ChangeListener, ActionListener {
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 1800;
	private ArrayList<String> Words=new ArrayList();{

	JSlider slider;
	JLabel label;
	JPanel panel = new JPanel (new GridBagLayout()); 
	
	
	public GraphicalHammingDistance() {
		setLayout(new GridBagLayout());
		GridBagConstraints space = new GridBagConstraints();
		
		space.gridx = 0;
		space.gridy = 0;
		label = new JLabel("Enter Hamming Distance: ");
		panel.add(label, space);
		add(panel);
		
		GridBagConstraints gaps = new GridBagConstraints();
		gaps.gridx = 0;
		gaps.gridy = 1;
		
		slider = new JSlider(1, 4);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		space.insets = new Insets(0, 80, 0, 0);
		space.anchor = GridBagConstraints.LINE_START;
		panel.add(slider, gaps);
		add(panel);
		
		space = new GridBagConstraints();
		space.gridx = 0;
		space.gridy = 3;
		
		JButton button = new JButton("Show Station");
		
		space.anchor = GridBagConstraints.LINE_START;
		space.insets = new Insets (20, 0, 10, 10);
		panel.add(button, space);
		add(panel);
		
		space = new GridBagConstraints();
		space.gridx = 0;
		space.gridy = 5; 
		
		space.insets = new Insets(20, 30, 10, 10);
		JTextArea bigBox = new JTextArea();
		bigBox.setSize(100, 100);
		panel.add(bigBox, space);
		add(panel);
		
		event cl = new event();
		slider.addChangeListener(cl);		
	}
	public class event implements ChangeListener {
		public void stateChanged (ChangeEvent cl) {
			int value = slider.getValue();
			label.setText("Enter Hamming Distance: " + value);
		}
	}
	public static void main (String [] args) {
		GraphicalHammingDistance test = new GraphicalHammingDistance();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setSize(500, 500);
		test.setVisible(true);
		test.setTitle("Hamming Distance");
	}


	// Read
	public void read(String fileName)throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		
		String strg;
		strg = br.readLine();
		while(strg != null)
		{ 
		words.add(strg.substring(0,4));
		strg = br.readLine();
		System.out.println(strg);
		}
		br.close();
	}
}