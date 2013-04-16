package blogg;


public class Category {
	private String name;

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		
		
		if (!name.contains(".")) {
			this.name = name;
		}
	}
}
