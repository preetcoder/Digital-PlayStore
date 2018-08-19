package playstore;

import java.util.*;
public class Book extends Reading{

	//declaring data members for class
	
	String[] authors;
	
	 
	// Book price is available
	public Book(String book_id, String book_name, double book_price, String book_publisher, String book_genre, int book_page_num, String[] book_author) {
		// passing values to super class
		super(book_id, book_name, book_price, book_publisher, book_genre, book_page_num);
		
		//setting author
		this.authors = book_author;
		
	}
	
	// If book is free
	
	public Book(String book_id, String book_name, String book_publisher, String book_genre, int book_page_num, String[] book_author) {
		// passing values to super class
		super(book_id, book_name, book_publisher, book_genre, book_page_num);
		
		//setting author
		this.authors = book_author;
		
	}
	
	// getter and setter functions for book
	
	public String printapp_authors() {
		
		return Arrays.toString(authors);
	}


}
