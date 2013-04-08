package blogg;

public class Post {
	public String title;
	public String content;
	
	public Writer writer;
	public  Category category; 
	
	public String getString() {
		return title + " by " + writer.name;
		
	}
}
