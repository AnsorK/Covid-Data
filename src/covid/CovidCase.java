package covid;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.text.NumberFormat;

/**
* Create new Covid 19 Cases 
* @author Ansor Kasimov
* @version 2.0
*/

public class CovidCase implements Comparable<CovidCase> {

	// Data variables
	private LocalDate dateReported;
	private String countryCode;
	private String country;
	@SuppressWarnings("unused")
	private String whoRegion;
	private int newCases;
	private int cumulativeCases;
	private int newDeaths;
	private int cumulativeDeaths;
	
	// Default constructor 
	public CovidCase() {
		dateReported = LocalDate.now();
		countryCode = "";
		country = "";
		whoRegion = "";
		newCases = 0;
		cumulativeCases = 0;
		newDeaths = 0;
		cumulativeDeaths = 0;
	}

	/**
	* Parameterized constructor
	* @param Array of string to parse into data variables
	*/
	public CovidCase(String[] s) {
		try {
			dateReported = LocalDate.parse(s[0]);
		} catch (DateTimeParseException dtpe) {
			dateReported = LocalDate.parse("1/1/1900");
		}
		countryCode = s[1];
		country = s[2];
		whoRegion = s[3];
		try {
			newCases = Integer.parseInt(s[4]);
		} catch (NumberFormatException nfe) {
			newCases = 0;
		}
		try {
			cumulativeCases = Integer.parseInt(s[5]);
		} catch (NumberFormatException nfe) {
			cumulativeCases = 0;
		}
		try {
			newDeaths = Integer.parseInt(s[6]);
		} catch (NumberFormatException nfe) {
			newDeaths = 0;
		}
		try {
			cumulativeDeaths = Integer.parseInt(s[7]);
		} catch (NumberFormatException nfe) {
			cumulativeDeaths = 0;
		}
	}
	
	/** @return Date reported */
	public LocalDate getDateReported() {
		return dateReported;
	}

	/** @return Country code */
	public String getCountryCode() {
		return countryCode;
	}

	/** @return Country */
	public String getCountry() {
		return country;
	}

	/** @return String representation of Covid Data */
	public String toString() {
		NumberFormat nf = NumberFormat.getInstance();
		return "[" + dateReported + "]\n" +  "COVID-19 Data for " + country + "\nCases today: " + nf.format(newCases) + "\nDeaths today: " + nf.format(newDeaths) + "\nCumulative cases to date: " + nf.format(cumulativeCases) + "\nCumulative deaths to date: " + nf.format(cumulativeDeaths);
	}

	/**
	* Compare CovidCase instance with another one to see if they have matching countries or country codes 
	* @return True if a match was found, false otherwise 
	*/
	public boolean equals(Object o) {
		if (o.getClass().getSimpleName().equals("CovidCase"))
			if ((countryCode.equalsIgnoreCase(((CovidCase) o).getCountryCode())) || (country.equalsIgnoreCase(((CovidCase) o).getCountry())))
				return true;
		return false;
	}
	
	// deprecated
	public int compareTo(CovidCase cc) {
		if (countryCode.equals(cc.getCountryCode())) 
			if (dateReported.equals(cc.getDateReported()))
				return 1;
		return 0;
	}
	
}
