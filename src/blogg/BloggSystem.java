package blogg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class BloggSystem {
	public List<Post> posts = new ArrayList<Post>();

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	String url = "jdbc:mysql://localhost:3306/Bloggen";
	String user = "root";
	String password = "";

	public void fill() {
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("select * from posts");

			while (rs.next()) {
				Post blogItem = new Post();
				blogItem.setTitle(rs.getString("title"));
				
				posts.add(blogItem);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
