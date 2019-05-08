package clubManager;

public class Member extends Person{
	private int membershipNumber;

	public int getMembershipNumber() {
		return membershipNumber;
	}

	public void setMembershipNumber(int membershipNumber) {
		this.membershipNumber = membershipNumber;
	}

	public Member(String surname, String firstName, String secondName, int membershipNumber) {
		super(surname, firstName, secondName);
		// TODO Auto-generated constructor stub
		this.membershipNumber = membershipNumber;
	}
	public Member(String surname, String firstName, int membershipNumber) {
		super(surname, firstName);
		// TODO Auto-generated constructor stub
		this.membershipNumber = membershipNumber;
	}
	public void show() {
		String format = "%-20s %5s\n";
		String s = super.toString() + " " + membershipNumber;
		System.out.format(format,"Member: ",s);
		}

}
