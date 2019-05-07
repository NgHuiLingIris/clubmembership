package clubManager;

public class Facility {
	//attributes starts here
	private String name;
	private String description;
	
	//getter and setter start here
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	//constructor starts here
	public Facility(String name, String description) {
		this.name = name;
		this.description = description;
	}
	//to make the second name attribute optional, we need a overloading constructor
	public Facility(String name) {
		this.name = name;
	}
	//method starts here
		public void show() {
			System.out.println(toString());
		}
		
		public String toString() {
			String s = null;
			if(description != null)
				s = name + ": " + description;
			//need different method for overloading constructor, cause now secondName printed as null
			else
				s = name;
			return s;
		}
}

