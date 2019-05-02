import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDistance {

	private String fileName = "Mesonet.txt";
	
	ArrayList<String> stations = new ArrayList<String>();
	
	
	public int[] checkAgainstAllWords(String word) throws IOException
	{
		// Reads in the mesonet.txt file
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		int[] results = new int[5];
		while(br.ready())
		{
			// Removes 4 letter word from string
			String str = br.readLine().substring(0, 4);
			
			int hDistance = getHammingDistance(word, str);
			if(hDistance == 0)
				results[0] = ++results[0];
			else if(hDistance == 1)
				results[1] = ++results[1];
			else if(hDistance == 2)
				results[2] = ++results[2];
			else if(hDistance == 3)
				results[3] = ++results[3];
			else if(hDistance == 4)
				results[4] = ++results[4];
			
		}
		
		br.close();
		return results;
		}
	
		public int getHammingDistance(String str1, String str2)
		{
		int count = 0;
		for(int i = 0; i < str1.length(); ++i)
		{
			// If the letters in a position are NOT the same, increase the count
			if(str1.charAt(i) != str2.charAt(i))
				++count;
		}
		return count;
		}
		public ArrayList<String> getStationList(String word, int target) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		ArrayList<String> stations = new ArrayList<String>();
		
		// If files has more lines...
		while(br.ready())
		{
			// Takes out the 4 letter word from the string
			String str = br.readLine().substring(0, 4);
			
			int hDistance = getHammingDistance(word, str);
			if(hDistance == target)
				stations.add(str);}
				br.close();
				return stations;
		}
	
	public ArrayList<String> getAllStations() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		// As long as the file has more lines, ...
		while(br.ready())
		{
			String str = br.readLine().substring(0, 4);
			stations.add(str);
		}
		
		br.close();
		return stations;
	}
}