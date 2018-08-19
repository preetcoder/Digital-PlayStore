package playstore;

public abstract class Reading extends Content{
	
	// Declaring data members for this class
	
	protected String publisher;
	protected String genre;
	protected int page_num;
	
	//genere getter
	
	public String print_genre() {
		return genre;
	}
	
	// if price available
	public Reading(String r_app_id, String r_app_name, double r_app_price, String r_app_publisher, String r_app_genre, int r_app_pagenum) {
		
		// setting super class variables
		
		super(r_app_id, r_app_name, r_app_price);
		
		// setting this class data members
		this.publisher = r_app_publisher;
		this.genre = r_app_genre;
		this.page_num = r_app_pagenum;
	}
	
	// if price free
		public Reading(String r_app_id, String r_app_name, String r_app_publisher, String r_app_genre, int r_app_pagenum) {
			
			// setting super class variables
			
			super(r_app_id, r_app_name);
			
			// setting this class data members
			this.publisher = r_app_publisher;
			this.genre = r_app_genre;
			this.page_num = r_app_pagenum;
		}

		// getter and setter
		public String printapp_publisher() {
			return publisher;
		}
		
		public String printapp_genre() {
			return genre;
		}
		
		public int printapp_page_num() {
			return page_num;
		}
		
}
