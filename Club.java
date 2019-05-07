package clubManager;


public class Club {
	private int membershipNumber;
	private int size;
	private Member members[];
	
	public Member[] getMembers() {
		return members;
	}

	public void setMembers(Member[] members) {
		this.members = members;
	}

	public int getMembershipNumber() {
		return membershipNumber;
	}

	public void setMembershipNumber(int membershipNumber) {
		this.membershipNumber = membershipNumber;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	
	public Club(int max){
		members = new Member[max];
		membershipNumber = 0;
		setSize(0);
	}
	
	public Member addMember(Person p){
		Member m = new Member (p.getSurname(), p.getFirstName(),p.getSecondName(),membershipNumber);
		members[membershipNumber] = m;
		membershipNumber++;
		size++;
		if(size == members.length)
		{
			Member[] temp = new Member[size * 2];
			for(int i = 0;i<members.length;i++)
			{
				temp[i]=members[i];
			}
			members = temp;
		}
		return m;
	}
	public void removeMember(int memberNo){
		Member m = null;
		if(size == 0) {
			System.err.println("Member List is already empty");	
		} else {
			members[memberNo] = m;
			compact();
			size--;
		}
	}
	public void showMembers() {
		for(int i = 0; i<size;i++)
		{
			members[i].show();
		}
	}
	public void compact() {
		Member temp = null;
		for(int i = 0; i<size;i++) {
			if(members[i]==null)
			{
				temp = members[i+1];
				members[i+1]=null;
				members[i]=temp;
			}
		}
	}


	
}
