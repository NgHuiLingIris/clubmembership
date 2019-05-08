package clubManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClubApplication {
	public void welcome() {
		System.out.println("Hello World!");
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Person p1 = new Person("Mary","Ng");
		Person p2 = new Person("Peter","Ng","Jas");
		Member m1 = new Member("Mary","Ng",123);
		Member m2 = new Member("Peter","Ng","Jas",456);
		Person p3 = new Person("Alice","Wang");
		Person p4 = new Person("John","Wang");
		Person p5 = new Person("Jonas","Tan");
		Facility f1 = new Facility("Badminton Court","To chill with the shuttlecock!");
		Facility f2 = new Facility("Bowling Centre");
		Facility f3 = new Facility("Tennis Court");
		Facility f4 = new Facility("Skating Rink", "To skate to your hearts' content");
		Facility f5 = new Facility("Movie Theatre","Watch the drama in action!");
		
		System.out.println("-----Adding members to Club Main:-----");
		Club g = new Club();
		g.addMember(p1).show();
		g.addMember(p2).show();
		g.addMember(p3).show();
		g.addMember(p4).show();
		g.addMember(p5).show();
		g.removeMember(2); //to remove member of Id = 2
		System.out.println("-----Showing Member:-----");
		g.showMembers();
		System.out.println("-----------------------------------------");
		System.out.println("-----Facility application starts here:-----");
		g.addFacility(f1);
		g.addFacility(f2);
		g.addFacility(f3);
		g.addFacility(f4);
		g.addFacility(f5);
		System.out.println("-----Retrieving Details of selected facility:-----");
		Facility h = g.getFacility("Tennis Court");
		h.show();
		System.out.println("-----Removing Skating Rink due to budget constraints:-----");
		g.removeFacility("Skating Rink");
		System.out.println("-----Showing all facilities of the club-----");
		g.show();
		g.getFacilities();
		
		System.out.println("-----Booking Register application starts here:-----");
		BookingRegister br = new BookingRegister();
		try {
		br.addBooking(m1, f1, LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(10));
		br.addBooking(m2, f2, LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(10));
		br.addBooking(m2, f3, LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(20));
		br.addBooking(m2, f1, LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(20));
		} catch (BadBookingException e1) {
			System.err.println(e1);
		}finally {
			System.out.println("\t\tBooking Completed");
		}
		ArrayList<Booking> blist = br.getBookings(f1, LocalDateTime.now(), LocalDateTime.now().plusDays(30));
		for(Booking b1: blist) {
			b1.show();
			System.out.println("\n");
		}
	}

}
