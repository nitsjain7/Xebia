package model;

/**
 * @author niyatee.jain User class to store user details
 *
 */
public class User {
	private String id;
	private String name;
	private String dOJ;

	public String getDOJ() {
		return dOJ;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDOJ(String firstRowSplit) {
		this.dOJ = firstRowSplit;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
