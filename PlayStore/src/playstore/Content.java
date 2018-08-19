package playstore;

import java.util.ArrayList;

public abstract class Content {

	// declaring data members for this class
	protected String ID;
	protected String app_name;
	protected double price;
	protected int num_downloads;
	protected ArrayList<Comment> reviews = new ArrayList<Comment>();

	// getter and setter functions

	public String printappID() {
		return ID;
	}

	public String printappname() {
		return app_name;
	}

	public double printappprice() {
		return price;
	}

	public int printapp_num_downloads() {
		return num_downloads;
	}

	public int set_app_num_downloads() {
		this.num_downloads = this.num_downloads + 1;
		return num_downloads;
	}

	// if price is available
	public Content(String content_app_id, String content_app_name, double content_app_price) {

		// setting content data members
		this.ID = content_app_id;
		this.app_name = content_app_name;
		this.price = content_app_price;
		this.num_downloads = 0; // setting download numbers to 0 initially

	}

	// if app is free
	public Content(String content_app_id, String content_app_name) {

		// setting content data members
		this.ID = content_app_id;
		this.app_name = content_app_name;
		this.price = 0; // setting price to 0
		this.num_downloads = 0; // setting download numbers to 0 initially

	}

	public void addAppReviews(Comment obj) {

		reviews.add(obj);
		if (this.getClass().getName() == "playstore.Game") {
			System.out.println(obj.userid.name + " added review '" + obj.print_commentstring() + "' on "
					+ this.getClass().getSimpleName() + " " + this.app_name + " for " + ((Game) this).os_type.print_app_os_type());
		}
		else {
			System.out.println(obj.userid.name + " added review '" + obj.print_commentstring() + "' on "
					+ this.getClass().getSimpleName() + " " + this.app_name );
		}
		// System.out.println(this.getClass().getSimpleName());

		
	}

	public void PrintAllComments() {

		for (int i = 0; i < reviews.size(); i++) {

			System.out.println(reviews.get(i).print_commentuserid() + ": " + reviews.get(i).print_commentstring());
			Comment c = reviews.get(i); 

			c.showreply(""); 

		}
	}

}
