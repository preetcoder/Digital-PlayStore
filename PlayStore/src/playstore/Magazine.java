package playstore;

public class Magazine extends Reading{

	// declaring data members for this class
	
	protected String mag_title;
	
	// if price
	public Magazine(String mag_id, String mag_name, int mag_price, String mag_publisher, String mag_genre, int mag_page_num, String mag_title) {
		
		// setting super class data members
		super(mag_id, mag_name, mag_price, mag_publisher, mag_genre, mag_page_num);
		
		//setting title 
		this.mag_title = mag_title;
	}
	
	// if free
	
	public Magazine(String mag_id, String mag_name, String mag_publisher, String mag_genre, int mag_page_num, String mag_title) {
		
		// setting super class data members
		super(mag_id, mag_name, mag_publisher, mag_genre, mag_page_num);
		
		//setting title 
		this.mag_title = mag_title;
	}
	

}
