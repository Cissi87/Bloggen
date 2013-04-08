import blogg.Category;
import blogg.Post;
import blogg.Writer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Writer writer = new Writer();
		writer.name = "Kalle";
		
		Category category = new Category();
		category.setName("Vardag");
		
		Post post = new Post();
		post.title = "Tisdag";
		post.content = "oj oj";
		post.writer = writer;
		post.category = category;
		
		
		System.out.println(post.getString());
		
	}

}
