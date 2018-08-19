package playstore;

import java.util.ArrayList;

public class user {

	// creating data members

	public String ID;
	public String name;
	public String phone;
	public double balance;

	public OS os_type; // instance variable of OS class

	boolean premium;

	// arraylist to store specific user purchase apps name
	public ArrayList<String> purchaseapp = new ArrayList<String>();

	// if user has balance

	public user(String u_id, String u_name, String u_phone, double u_balance, OS type) {
		// setting data 
		this.ID = u_id;
		this.name = u_name;
		this.phone = u_phone;
		this.balance = u_balance;
		this.os_type = type;
		// user to no premium
		this.premium = false;
	}

	// if user has no balance

	public user(String u_id, String u_name, String u_phone, OS type) {
		// setting data 
		this.ID = u_id;
		this.name = u_name;
		this.phone = u_phone;
		this.balance = 0; // setting balance to 0
		this.os_type = type;

		// user to no premium
		this.premium = false;
	}

	// getter and setter for users
	public String print_userId() {
		return ID;
	}

	public String print_username() {
		return name;
	}

	public String print_userphone() {
		return phone;
	}

	public double print_userbalance() {
		return balance;
	}

	// creating “becomePremium” method

	public void becomePremium() throws CustomExp {
		// check if user is already premium
		if (!this.premium) {
			if (this.balance >= 100) {

				// make premium user and deduct $100 from balance
				this.premium = true;
				this.balance -= 100;

				System.out.println(this.name + " is now premium user!");
			} else {

				throw new CustomExp("Not enough Balance" + " in " + this.name + " Account.");
			}
		} else {

			throw new CustomExp("User already a premium member");
		}

	}

	// buyApp method
	public void buyApp(Content obj) {

		// if app is a game

		if (obj instanceof Game) {
			// System.out.println(((Game) obj).os_type.print_app_os_type());

			// checking user OS type and version

			if (this.os_type.print_app_os_type() == ((Game) obj).os_type.print_app_os_type()
					&& this.os_type.print_app_os_version() >= ((Game) obj).os_type.print_app_os_version()) {

				// check if user is premium

				if (this.premium) {

					// check balance of user and setting price to 20 % discounted price

					if (this.balance >= (double) (obj.price * (80.0f / 100.0f))) {

						this.balance -= (double) (obj.price * (80.0f / 100.0f));
						obj.set_app_num_downloads();
						(this.purchaseapp).add(obj.getClass().getSimpleName() + " " + ((Game) obj).os_type.print_app_os_type() + " for " +obj.app_name);
						
						

						System.out.println(this.name + " bought " + obj.app_name);

					} else {
						// use exception
						System.out.println(this.name + " doesn't have sufficient balance to purchase this");
					}
				}

				else {

					if (this.balance >= obj.price) {

						this.balance -= obj.price;
						obj.set_app_num_downloads();
						
						(this.purchaseapp).add(obj.getClass().getSimpleName() + " " + ((Game) obj).os_type.print_app_os_type() + " for " + obj.app_name);
						
						System.out.println(this.name + " bought " + obj.app_name);

					} else {
						// use exception
						System.out.println(this.name + " doesn't have sufficient balance to purchase this");
					}

				}

			} else {
				System.out.println(this.name + " cannot buy " + obj.app_name + " for "
						+ ((Game) obj).os_type.print_app_os_type() + " due to OS mismatch");

				// OS matches

			}

		} else {

			// purchasing app is not of game type
			

			if (this.premium) {

				// check balance of user and setting price to 20 % discounted price

				if (this.balance >= (double) (obj.price * (80.0f / 100.0f))) {

					this.balance -= (double) (obj.price * (80.0f / 100.0f));
					obj.set_app_num_downloads();
					(this.purchaseapp).add(obj.getClass().getSimpleName() + " " +obj.app_name);
					
					
					
					System.out.println(this.name + " bought " + obj.app_name);

				} else {
					// use exception
					System.out.println(this.name + " doesn't have sufficient balance to purchase this");
				}
			}

			else {

				if (this.balance >= obj.price) {

					this.balance -= obj.price;
					obj.set_app_num_downloads();
					(this.purchaseapp).add(obj.getClass().getSimpleName() + " " +obj.app_name);
					

					System.out.println(this.name + " bought " + obj.app_name);

				} else {
					// use exception
					System.out.println(this.name + " doesn't have sufficient balance to purchase this");
				}

			}
		}

	}

	// showUserApps method

	public void showUserApps() {
		System.out.print("The contents bought by " + this.name + " - ");
		
		String value = "";
		for (String string : purchaseapp) {
			value += string + ",";
		}
		System.out.println(value.replaceAll(",$", ""));
	}

}
