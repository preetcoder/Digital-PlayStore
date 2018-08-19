package playstore;

import java.util.ArrayList;

public class Comment {
	
	// declaring data members
	protected user userid;
	
	protected String comment;
	
	// comment type of array object
	
	protected ArrayList<Comment> reply= new ArrayList<Comment>();
	
	// getter and setter function
	public String print_commentstring() {
		//System.out.println("aaya");
		return comment;
	}
	
	public String print_commentuserid() {
		return userid.ID;
	}
	
	public void set_commentstring(String comment_val) {
		this.comment = comment_val;
	}
	
	public Comment(user obj, String comnt) {
		//System.out.println(obj.name);
		this.comment = comnt;
		this.userid = obj;
		
	}
	
	public void replyonApp(Comment comment){ // to add replies to the comments by the user
		reply.add(comment);
		System.out.println(comment.userid.name + " replied \"" + comment.comment + "\"");
	}
	
	public void showreply(String padding) {
		
		for(int hh = 0; hh<reply.size();hh++) {
			
			System.out.println(padding+"\t"+reply.get(hh).print_commentuserid() +": "+reply.get(hh).print_commentstring());
			
			Comment rc = reply.get(hh);		// creating new object for index
			
			
				rc.showreply(padding+"\t");			
			
			
		}
		
	}
	
	
	

}
