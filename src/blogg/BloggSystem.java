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

	public Writer getWriterById(int id) {
		for(int i = 0; i < Writers.size(); i++) {
			if (id == Writers.get(i).getId()) {
				return Writers.get(i);
			}
		} 
		return null;
	}
	
	public Category getCategoryById(int id) {
		for(int i = 0; i < Categories.size(); i++) {
			if (id == Categories.get(i).getId()) {
				return Categories.get(i);
			}
		}
		return null;
	}
	
	public void fill() {
		try {
			con = DriverManager.getConnection(url, user, password);
			
			st = con.createStatement();
			rs = st.executeQuery("select * from categories");

			while (rs.next()) {
				Category category = new Category();
				category.setName(rs.getString("name"));
				category.setId(rs.getInt("id"));
				Categories.add(category);

			}
			
			st = con.createStatement();
			rs = st.executeQuery("select * from writers");

			while (rs.next()) {
				Writer writer = new Writer();
				writer.setName(rs.getString("name"));
				writer.setId(rs.getInt("id"));
				Writers.add(writer);

			}
			
			
			st = con.createStatement();
			rs = st.executeQuery("select * from posts");

			while (rs.next()) {
				Post blogItem = new Post();
				blogItem.setTitle(rs.getString("title"));
				blogItem.setContent(rs.getString("post"));
				blogItem.setId(rs.getInt("id"));
				blogItem.setWriter(getWriterById(rs.getInt("writer")));
				blogItem.setCategory(getCategoryById(rs.getInt("category")));
				posts.add(blogItem);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Writer> getWriters() {
		return Writers;
	}

	public void setWriters(List<Writer> writers) {
		Writers = writers;
	}
}
