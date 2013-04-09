package blogg;

public class Post {
	public String title;
	public String content;
	
	public Writer writer;
	public  Category category; 
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getString() {
		return title + " by " + writer.name;
		//Hej hopp gummi...
		
	}
}
