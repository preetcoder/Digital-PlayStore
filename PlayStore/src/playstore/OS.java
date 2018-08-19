package playstore;

public class OS {
	
	// creating data members
	public String os_type;
	public int ver_num;
	
	
	public String print_app_os_type() {
		return os_type;
	}
	
	public int print_app_os_version() {
		return ver_num;
	}

	public OS(String type, int v_num) {
		// setting value in constructor
		
		this.os_type = type;
		this.ver_num = v_num;
	}

}
