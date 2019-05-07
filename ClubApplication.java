package clubManager;

public class ClubApplication {
	public void welcome() {
		System.out.println("Hello World!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ClubApplication a = new ClubApplication();
		//a.welcome();
		Person a = new Person("Mary","Ng");
		a.show();
		Person b = new Person("Peter","Ng","Jas");
		b.show();
		Facility c = new Facility("Raffles Town Club","For atas people");
		c.show();
		Facility d = new Facility("Orchid Bowl");
		d.show();
		Person e = new Member("Mary","Ng",123);
		e.show();
		Person f = new Member("Peter","Ng","Jas",456);
		f.show();
		Club g = new Club(2);
		System.out.println("Add to club:");
		g.addMember(b).show();
		g.addMember(a).show();
		g.addMember(new Person("Alice","Wang")).show();
		g.addMember(new Person("John","Wang")).show();
		g.addMember(new Person("Jonas","Tan")).show();
		g.removeMember(2);
		System.out.println("Show Members:");
		g.showMembers();
	}

}
