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

public class GraphicalHammingDistance extends JFrame {

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
		
	}
}
