package playstore;

public class Game extends Content {
	
	// Declaring Data member variables
	
	protected boolean isMultiPlayer;
	
	protected OS os_type;		// instance variable of OS class
	
	// if game price is available
	public Game(String app_id, String app_name, double app_price, boolean app_multi, OS type) {
		
		//setting content class members
		super(app_id, app_name, app_price);
		this.isMultiPlayer = app_multi;
		this.os_type = type;		// adding type value to os object arraylist
	}
	
	// if game price is free
		public Game(String app_id, String app_name, boolean app_multi, OS type) {
			
			//setting content class members
			super(app_id, app_name);
			this.isMultiPlayer = app_multi;
			this.os_type = type;		// adding type value to os object arraylist
		}
		

}
