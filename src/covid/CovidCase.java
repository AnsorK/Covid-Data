package covid;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.text.NumberFormat;

/**
* Create new Covid 19 Cases 
* @author Ansor Kasimov
* @version 1.0
*/

public class CovidCase implements Comparable<CovidCase> {

	// Data variables
	private LocalDate dateReported;
	private String countryCode;
	private String country;
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
	
	/**
	* Parameterized constructor
	* @params Date reported, Country code, Country, WHO region, New cases, Cumulative cases, New deaths, Cumulative deaths
	*/
	public CovidCase(LocalDate dateReported, String countryCode, String country, String whoRegion, int newCases, int cumulativeCases, int newDeaths, int cumulativeDeaths) {
		this.dateReported = dateReported;
		this.countryCode = countryCode;
		this.country = country;
		this.whoRegion = whoRegion;
		this.newCases = newCases;
		this.cumulativeCases = cumulativeCases;
		this.newDeaths = newDeaths;
		this.cumulativeCases = cumulativeDeaths;
	}

	/**
	* @return Date reported
	*/
	public LocalDate getDateReported() {
		return dateReported;
	}

	/**
	* @return Country code
	*/
	public String getCountryCode() {
		return countryCode;
	}

	/**
	* @return Country 
	*/
	public String getCountry() {
		return country;
	}

	/**
	* @return WHO Region 
	*/
	public String getWhoRegion() {
		return whoRegion;
	}

	/** 
	* @return New cases
	*/
	public int getNewCases() {
		return newCases;
	}

	/**
	* @return Cumulative cases 
	*/
	public int getCumulativeCases() {
		return cumulativeCases;
	}

	/**
	* @return New deaths 
	*/
	public int getNewDeaths() {
		return newDeaths;
	}

	/**
	* @return Cumulative deaths 
	*/
	public int getCumulativeDeaths() {
		return cumulativeDeaths;
	}

	/**
	* Update date reported
	* @param Date reported
	*/
	public void setDateReported(LocalDate dateReported) {
		this.dateReported = dateReported;
	}

	/**
	* Update country code
	* @param Country code
	*/
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	* Update country
	* @param Country
	*/
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	* Update WHO region
	* @param WHO region
	*/
	public void setWhoRegion(String whoRegion) {
		this.whoRegion = whoRegion;
	}

	/**
	* Update new cases
	* @param New cases
	*/
	public void setNewCases(int newCases) {
		this.newCases = newCases;
	}

	/**
	* Update cumulative cases
	* @param Cumulative cases
	*/
	public void setCumulativeCases(int cumulativeCases) {
		this.cumulativeCases = cumulativeCases;
	}

	/**
	* Update new deaths
	* @param New deaths
	*/
	public void setNewDeaths(int newDeaths) {
		this.newDeaths = newDeaths;
	}

	/**
	* Update cumulative deaths
	* @param Cumulative deaths
	*/
	public void setCumulativeDeaths(int cumulativeDeaths) {
		this.cumulativeDeaths = cumulativeDeaths;
	}

	/**
	* @return String representation of Covid Data
	*/
	public String toString() {
		NumberFormat nf = NumberFormat.getInstance();
		return "[" + this.getDateReported() + "]\n" +  "COVID-19 Data for " + this.getCountry() + "\nCases today: " + nf.format(this.getNewCases()) + "\nDeaths today: " + nf.format(this.getNewDeaths()) + "\nCumulative cases to date: " + nf.format(this.getCumulativeCases()) + "\nCumulative deaths to date: " + nf.format(this.getCumulativeDeaths());
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
