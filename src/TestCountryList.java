/**
 *  Tests the CountryList class by creating multiple objects of type CountryNode.
 *  Creates one object of type CSVReader class, which reads input from a CSV file. Uses
 *  the attributes stored in CSVReader object to create objects of type Country class.
 *  Then adds the newest country read into the list
 *
 * @author Foothill College, [YOUR NAME HERE]
 *
 * REMINDER: Include text cases in addition to those provided.
 *           See suggestions at the end of the main() method.
 */


import java.util.Random;
import java.util.Scanner;


public class TestCountryList 
{
	/**
	 * Builds a list of countries to debug.
	 */
	private void debugListOfCountries(Country [] allCountries)
	{
		// TO COMPLETE
		// Note: The implementation of method is optional.
		//       The purpose is to help you debug
	}

	/**
	 * Builds a random list of countries.
	 * @param allCountries      An array of Country objects
	 */
	private void testRandomListOfCountries(Country [] allCountries)
	{	
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many countries do you want to add to the list?");
		int requestedSize = Integer.parseInt( keyboard.nextLine() );

		// Build the list out of a random selection of countries.
		Random random = new Random();
		CountryList selectedCountries = new CountryList();
		for (int i = 0; i < requestedSize; i++)
		{
			int selectedIndex = random.nextInt(allCountries.length);
			selectedCountries.add(allCountries[selectedIndex]);
		}


		// Note: To debug your list, do not comment this line out
		System.out.println("List of countries: " + selectedCountries);


		// Note: To debug specific elements of your list, do not comment this line out
		int index = 0;
		Country first = selectedCountries.getIndex(index);
		index = selectedCountries.size()/2;
		Country middle = selectedCountries.getIndex(index)
				index = selectedCountries.size()-1;
		Country last = selectedCountries.getIndex(index)


				// Check if the name of a country is in the list.
				// If the country is found, print the details.
				// Otherwise output not found.
				System.out.println("\nWhat country do you want to search for?");
		String countryNameToFind = keyboard.nextLine();
		Country foundCountry = selectedCountries.contains(countryNameToFind);
		if (foundCountry != null)
		{
			System.out.println("Country " + countryToFind + " found with details:" + foundCountry);
		}
		else
			System.out.println("Country " + countryToFind + " not found.");

	}

	/**
	 * Uses a CSV to parse a CSV file.
	 * Adds the data for each country to an array of Country objects.
	 * Adds a random selection of countries to a CountryList object.
	 */
	public static void main(String[] args) 
	{
		// Create and set objects of type Country 
		//
		final String FILENAME = "resources/cellular.csv";	// Directory path for Mac OS X
		//final String FILENAME = "resources\\cellular.csv";	// Directory path for Windows OS (i.e. Operating System)
		final int NUM_COUNTRIES_TO_TEST = 3;			    // Note: Include test cases in addition to 3


		// Parse the CSV data file
		//
		CSVReader parser = new CSVReader(FILENAME);

		String [] countryNames = parser.getCountryNames();
		int [] yearLabels = parser.getYearLabels();
		double [][] parsedTable = parser.getParsedTable();		


		// Create and set objects of type Country 
		//
		Country [] countries;

		// All the countries read fby CSVReader
		countries = new Country[countryNames.length];

		// Note: If you are debugging, use this version instead to limit the number of countries
		// countries = new Country[NUM_COUNTRIES_TO_TEST];

		Country current;
		for (int countryIndex = 0; countryIndex < countries.length; countryIndex++)
		{
			int numberOfYears = yearLabels.length;   // OR numberOfYears = dataTable[countryIndex].length;

			current = new Country(countryNames[countryIndex], numberOfYears);

			for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++)
			{
				double [] allSubscriptions = parsedTable[countryIndex];
				double countryData = allSubscriptions[yearIndex];
				current.addSubscriptionYear(yearLabels[yearIndex], countryData);
			}
			countries[countryIndex] = current;
		}

		TestCountryList application = new TestCountryList();

		// Note: Initially, to test your output you may hard code the number of 
		//       countries added, and the array positions selected.
		//		 However, make sure to comment this out before submitting your work.
		//application.debugListOfCountries(countries);

		application.testRandomListOfCountries(countries);

		// flush the error stream
		System.err.flush();

		System.out.println("\nDone with TestCountryList.");
	}
}