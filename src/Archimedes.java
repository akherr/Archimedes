
/**
 * @author Austin Herr 
 * 5/14/14
 * 
 * This program is designed to calculate any Roman numeral input up to 4999.
 * The only specified input from the user is the filepath for the input file,
 * 		which is specified when the program is run.
 * The only output is a System.out of the numerical conversion.
 */
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Archimedes {
	
	Scanner s;
	String filePath = JOptionPane.showInputDialog("Specify File Path:");
	
	//This array defines the numerals that have two characters
	String[] doubleLetters = new String[] {"IV","IX","XL","XC","CD","CM"};
	
	//Initializes the scanner and calls the process function
	public void initialize()
	{
		try
        {
            s = new Scanner(new File(filePath));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("File not found");
        }
		process(s.next());
	}
	
	//The main processing function. Takes in the whole numeral and 
	//	breaks it into individual parts for addition.
	private void process(String numeral)
	{
		//variable to hold the final conversion number
		int conversion = 0;
		int numeralLength = numeral.length();
		
		for(int i = 0; i < numeralLength; i++)
		{
			//checks if there is another character ahead of the current one
			if((i+1) < (numeralLength))
			{
				boolean doubleMatch = false;
				
				String twoChars = numeral.substring(i, i+2);
				//for loop to check if there is a match to the doubleLetters
				//   array, and set doubleMatch true
				for(int j = 0; j < doubleLetters.length; j++)
				{
					if(twoChars.equals(doubleLetters[j]))
					{
						doubleMatch = true;
					}
				}
				//if there is a doubleLetter match, use the convert function
				//	for two characters, and increase the index 
				if(doubleMatch == true)
				{
					conversion+= convert(twoChars);
					i++;
				}
				else
				{
					conversion += convert(numeral.charAt(i));
				}
			}
			else{
				conversion += convert(numeral.charAt(i));
			}
		}
		System.out.println(conversion);
	}
	
	//Convert the double letter string and return the int
	private int convert(String s)
	{
		int number = 0;
		if(s.equals("CM")) number = 900;
		if(s.equals("CD")) number = 400;
		if(s.equals("XC")) number = 90;
		if(s.equals("XL")) number = 40;
		if(s.equals("IX")) number = 9;
		if(s.equals("IV")) number = 4;
		return number;
	}
	
	//convert the single character and return the int
	private int convert(char c)
	{
		int number = 0;
		if(c == 'M') number = 1000;
		if(c == 'D') number = 500;
		if(c == 'C') number = 100;
		if(c == 'L') number = 50;
		if(c == 'X') number = 10;
		if(c == 'V') number = 5;
		if(c == 'I') number = 1;
		return number;
	}
	
	public static void main (String[] args)
	{
		Archimedes a = new Archimedes();
		a.initialize();
	}

}
