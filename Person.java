package clubManager;

public class Person {
	//three attributes: surname, firstName, secondName
	private String surname;
	private String firstName;
	private String secondName;
	
	//getter setter starts here
	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getSecondName() {
		return secondName;
	}


	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	//constructor starts here
	
	public Person(String surname, String firstName, String secondName) {
		this.surname = surname;
		this.firstName = firstName;
		this.secondName = secondName;
	}
	//to make the second name attribute optional, we need a overloading constructor
	public Person(String surname, String firstName) {
		this.surname = surname;
		this.firstName = firstName;
	}
	
	//method starts here
	public void show() {
		String format = "%-20s %5s\n";
		System.out.format(format,"Person: ",toString());
	}
	public String toString() {
		String s = null;
		if(secondName != null)
			s = surname + " " + firstName + " "+ secondName;
		//need different method for overloading constructor, cause now secondName printed as null
		else
			s = surname +" "+firstName;
		return s;
	}
	
}
