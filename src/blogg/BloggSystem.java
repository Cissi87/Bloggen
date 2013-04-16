package blogg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class BloggSystem {
	public List<Post> posts = new ArrayList<Post>();
	public List<Writer> Writers = new ArrayList<Writer>();
	public List<Category> Categories = new ArrayList<Category>(); 

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	String url = "jdbc:mysql://localhost:3306/Bloggen";
	String user = "root";
	String password = "root";

	public void fill() {
		try {
			con = DriverManager.getConnection(url, user, password);
			
			st = con.createStatement();
			rs = st.executeQuery("select * from categories");

			while (rs.next()) {
				Category category = new Category();
				category.setName(rs.getString("name"));
				Categories.add(category);

			}
			
			st = con.createStatement();
			rs = st.executeQuery("select * from writers");

			while (rs.next()) {
				Writer writer = new Writer();
				writer.setName(rs.getString("name"));
				Writers.add(writer);

			}
			
			
			st = con.createStatement();
			rs = st.executeQuery("select * from posts");

			while (rs.next()) {
				Post blogItem = new Post();
				blogItem.setTitle(rs.getString("title"));
				blogItem.setContent(rs.getString("post"));
				posts.add(blogItem);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
