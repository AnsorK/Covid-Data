package covid;
import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.util.*;

/**
* Fetch and parse WHO Covid-19 data 
* @author Ansor Kasimov
* @version 2.0
*/

public class Application {

		public static void main(String[] args) {
			
			// Store Covid-19 data
			LinkedList<CovidCase> list = new LinkedList<CovidCase>();
			
			// CSV file
			URL dataURL = null;
			
			try {
				dataURL = new URL("https://covid19.who.int/WHO-COVID-19-global-data.csv");
			} catch (MalformedURLException murle) {
				System.out.println("Error getting website");
			}
			
			// Scanner
			Scanner sc;
			String line;
			
			// Parse the data and turn them into instances of CovidCase
			try {
				sc = new Scanner(dataURL.openStream());
				sc.nextLine();
				while (sc.hasNextLine()) {
					line = sc.nextLine();
					String regex = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
					String [] values = line.split(regex); 
					CovidCase cc = new CovidCase(values);
					if ((cc.getDateReported().equals(LocalDate.now())) || (cc.getDateReported().equals(LocalDate.now().minusDays(1))))
						list.add(cc);
				}
				sc.close();
			} catch (IOException ioe) {
				System.out.println("Error adding data to list");
			}
				
			// 1st question
			sc = new Scanner(System.in);
			System.out.print("Enter a valid country name or country code (q to quit): ");
			String input = sc.nextLine();
			
			// End if q is entered, else loop questions
			if (input.equals("q")) {
				sc.close();
				System.out.println("\nGoodbye!");
			} else {	
				while (!input.equals("q")) {
					
					// search by country name
					if (input.length() > 2) {
						for (CovidCase cc : list) { 
							if (cc.getCountry().toLowerCase().contains(input.toLowerCase())) {
								System.out.println("\n" + list.get(list.lastIndexOf(cc)));
								break;
							} 
						}
					} 
					
					// search by country code
					else {
						for (CovidCase cc : list) { 
							if (cc.getCountryCode().toLowerCase().equals(input.toLowerCase())) {
								System.out.println("\n" + list.get(list.lastIndexOf(cc)));
								break;
							} 
						} 
					}
					
					System.out.print("\nEnter another valid country name or country code (q to quit): ");
					input = sc.nextLine();

				}
				sc.close();
				System.out.println("\nGoodbye!");
			}
			
		}

	}


