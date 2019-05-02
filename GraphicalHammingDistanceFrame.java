
public class GraphicalHammingDistanceFrame extends JFrame
{
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 1800;
	
	JPanel originalPanel = new JPanel ();
	JPanel originalPanelOne = new JPanel ();
	JPanel originalPanelTwo = new JPanel();
	JPanel creativePanel = new JPanel ();
	
	JLabel hdLabel = new JPanel("Enter Hamming Dist:");
	JTextField hdField = new JTextField("2");
	JSlider hdSlider = new JSlider(1, 4, 2);
	JButton showStationButton = new JButton("Show Station");
}
