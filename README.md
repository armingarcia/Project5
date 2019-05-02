# Project5

![](./UML.png?raw=true)

There are 3 classes that I have made for this project which consist of the following:
    1. GraphicalHammingDistanceFrame.java
    2. Hamming Distance.java
    3. SelectedStation.java
    
The purpose of the GraphicalHammingDistanceFrama.java class represents an interactive HammingDistance calculator.

  - First, the JComponents are placed in their proper positions within the frame and then functionality is added to each component.
  - There are two main panels within this class that are used for the frame. The "original" component is use for the write-up portion.
  - Meanwhile, the remaining panels are positioned in the frame using the GridLayout
    - The subpanels that are used for arranging the components are the GridBagLayout along with GridBagConstraints which permit more         tolerance as to positioning them.
 
Additionally, the functionality for the creative panel was the last one added since they need to be properly positioned in order for the creative function to work properly. The purpose of my creative function is a generator that picks one of the StationID's found in the Mesonet.txt. This function adds to the list located in the JComboBox and selects that StationID as the item selected in the JComboBox.

Next, the Hamming Distances are calculated in the same manner as the "Calculation" button.

After components are added to the OriginalPanelOne and OriginalPanelTwo, it allows for the creation of a GUI that displays all the information related to the Hamming Distances between any of the StationID's with any two 4-letter station.

This frame permits for the for the generation of a random series that consists of 4 letters which are added and later used to calculate the hamming distance such as the station ID's which are read in the original file.

Once the functionality is added to the multiple JFields, it will generate a list of multiple stationID's that have a hamming distance of the int located in the distField along with the word that is selected in the JComboBox.

The function used for calculation stores the number of count in words within the text file. Only words with a hamming distance of 0, 1, 2, 3, or 4.

For the "public int[] getHammingDistance()" the purpose is to create an Hamming Distance object named hd that uses the item that is selected within the JComboBox which will generate an int array of the total number of stations found within that list that have hamming distances of 0, 1, 2, 3, and 4.

It will then return where the int[] is located when the index is at 0 and shows the number of stations consisting of hamming distance of zero within the selected word. Index [1] contains the total number of stations of hamming distance of '1' within the selected word. Index [1] contains the total number of station found in hamming distance of 1.

Public ArrayList<String> getStationList(); creating a Hamming Distance object that uses the word that is selected from the JComboBox and the integer in the distance field then is used to generate the list of station IDs the file hamming distance with that integer has.
Then, ArrayList of station ID's have a hamming distance of the distField within the JComboBox.
