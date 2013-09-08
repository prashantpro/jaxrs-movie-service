package org.prashantpro.jaxrs.movie;

/**
 * @author Prashant Padmanabhan <http://javaspecialist.wordpress.com>
 * 
 */
public class Movie {

	private int year;
	private String title;
	private String genre;

	public Movie(int year, String title, String genre) {
		this.year = year;
		this.title = title;
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
