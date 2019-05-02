import java.util.Random;
public class SelectedStation {
	
	// Generates a random 4-letter station ID
	 
	public String provideSelectedStation()
	{
		String station = "";
		
		for(int i = 0; i < 4; ++i)
		{
			Random r = new Random();
			char c = (char)(r.nextInt(26) + 'A');
			station += Character.toString(c);
		}
		
		return station;
	}
	
}