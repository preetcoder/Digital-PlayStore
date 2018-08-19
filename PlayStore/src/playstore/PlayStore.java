/**
 * 
 */

package playstore;

import java.util.ArrayList;


public class PlayStore {

	// declaring arraylist for reviews and users

	public ArrayList<Content> apps = new ArrayList<Content>();
	public ArrayList<user> users = new ArrayList<user>();

	
	public void addApps(Content obj) {

		boolean exist = false;

		// checking if app id is already present if not then add app

		for (int i = 0; i < apps.size(); i++) {

			if (apps.get(i).ID == obj.ID) {
				exist = true;
				System.out.println(obj.getClass().getSimpleName() + " " + obj.ID + " already exists");
				// if find, exist from loop
				break;
			}

		}
		if (!exist) {
			apps.add(obj);
			
			if (obj.getClass().getName() == "playstore.Game") {
				// System.out.println(((Game) obj).os_type.print_app_os_type() + "dd");
				System.out.println(obj.getClass().getSimpleName() + " " + obj.app_name + " for "
						+ ((Game) obj).os_type.print_app_os_type() + " is added to playstore");
			} else {

				System.out.println(obj.getClass().getSimpleName() + " " + obj.app_name + " is added to playstore");

			}

		}


	}

	// showAllApps Method

	public void showAllApps(String mystring) {
		String allcontent = "";

		if (mystring == "all") {

			for (int i = 0; i < apps.size(); i++) {

				allcontent += apps.get(i).app_name + ",";
			}

			// removing , from last word

			System.out.println("The contents in the playstore are - " + allcontent.replaceAll(",$", ""));

		}

		else if (mystring == "game") {

			for (int i = 0; i < apps.size(); i++) {
				if (apps.get(i).getClass().getName() == "playstore.Game") {
					allcontent += apps.get(i).app_name + ",";
				}
			}

			// removing , from last word

			System.out.println("The Games in the playstore are - " + allcontent.replaceAll(",$", ""));

		}

		else if (mystring == "magazine") {

			for (int i = 0; i < apps.size(); i++) {
				if (apps.get(i).getClass().getName() == "playstore.Magazine") {
					allcontent += apps.get(i).app_name + ",";
				}
			}

			// removing , from last word

			System.out.println("The Magazines in the playstore are - " + allcontent.replaceAll(",$", ""));

		}

		else if (mystring == "book") {

			for (int i = 0; i < apps.size(); i++) {
				if (apps.get(i).getClass().getName() == "playstore.Book") {
					allcontent += apps.get(i).app_name + ",";
				}
			}

			// removing , from last word

			System.out.println("The Books in the playstore are - " + allcontent.replaceAll(",$", ""));

		}

	}

	// Genrefunc Method

	public void Genrefunc(String genre) {

		String genres = "";

		for (int i = 0; i < apps.size(); i++) {

			// Genre is only in reading class so extending 2 classes book and magazine
			if ((apps.get(i).getClass().getName() == "playstore.Book" && ((Reading) apps.get(i)).print_genre() == genre)
					|| (apps.get(i).getClass().getName() == "playstore.Magazine"
							&& ((Reading) apps.get(i)).print_genre() == genre)) {

				genres += apps.get(i).getClass().getSimpleName() + " " + apps.get(i).app_name + ",";
			}

		}

		// removing , from last word

		System.out.println("The " + genre + " in playstore are - " + genres.replaceAll(",$", ""));

	}

	// Add user method

	public void addNewUser(user obj) {

		boolean user_exist = false;

		// checking if user id is already present if not then add user

		for (int i = 0; i < users.size(); i++) {

			if (users.get(i).ID == obj.ID) {
				user_exist = true;
				System.out.println(obj.ID + " already exists");
				// if find, exist from loop
				break;
			}

		}
		if (!user_exist) {
			users.add(obj);
			System.out.println("User " + obj.name + " has joined!");
		}

		// System.out.println(users.get(0).ID);
	}

	public static void main(String[] args) {

		PlayStore admin = new PlayStore();
		// adding new readings
		String[] authors = { "L. Tolstoy" };

		Book b1 = new Book("R1", "War and Peace", 12, "The Russian Messenger", "Novel", 1225, authors);
		String[] authors2 = { "F. Scott Fitzgerald" };

		Book b2 = new Book("R2", "The great gatsby", 10, "Charles Scribner's Sons", "Novel", 180, authors2);

		String[] authors3 = { "Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein" };

		Book b3 = new Book("R3", "Introduction to algorithms", 100, "MIT Press", "Computer Science", 1312, authors3);

		Magazine m1 = new Magazine("R4", "Forbes", 8, "Forbes Media", "Business", 50, "World’s richest under 30");

		admin.addApps(b1);
		admin.addApps(b2);
		admin.addApps(b3);
		admin.addApps(m1);

		// adding new games
		OS os1 = new OS("Android", 4);
		OS os2 = new OS("iOS", 10);
		OS os3 = new OS("Android", 3);

		Game g1 = new Game("g1", "Pokemon", 5, false, os1);
		Game g2 = new Game("g2", "Pokemon", 5, false, os2);
		Game g3 = new Game("g3", "MineCraft", 2, true, os1);

		admin.addApps(g1);
		admin.addApps(g2);
		admin.addApps(g3);

		user u1 = new user("u1", "John Doe", "0412000", 12000, os1);
		user u2 = new user("u2", "Jane Doe", "0412001", 120, os1);
		user u3 = new user("u3", "Dave Roe", "0412002", 100, os2);
		user u4 = new user("u4", "Diane Roe", "0412003", 1, os3);

		admin.addNewUser(u1);
		admin.addNewUser(u2);
		admin.addNewUser(u3);
		admin.addNewUser(u4);

		try {
			u1.becomePremium();

		} catch (CustomExp e) {
			System.out.println(e.getMessage());
		}

		u1.buyApp(b1);
		u1.buyApp(b1);
		u1.buyApp(g1);
		u3.buyApp(m1);
		u2.buyApp(b1);

		u1.showUserApps();

		// pass value as game, all, book, magazine in parameter to see content
		admin.showAllApps("magazine");

		admin.Genrefunc("Novel");

		// comment object
		Comment cmnt = new Comment(u1, "This is a fantastic game!");

		g1.addAppReviews(cmnt);

		Comment r1 = new Comment(u2, "I never liked this game!");
		cmnt.replyonApp(r1);

		Comment r2 = new Comment(u1, "Really??");
		r1.replyonApp(r2);

		Comment cmnt2 = new Comment(u3, "The game crashes frequently.");
		g1.addAppReviews(cmnt2);

		g1.PrintAllComments();

	}

}
