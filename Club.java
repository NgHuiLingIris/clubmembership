package clubManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Club {
	private int membershipNumber;
	private ArrayList<Member> members = new ArrayList<Member>();
	public int getMembershipNumber() {
		return membershipNumber;
	}
	public void setMembershipNumber(int membershipNumber) {
		this.membershipNumber = membershipNumber;
	}
	public Member addMember(Person p){
		Member m = new Member (p.getSurname(), p.getFirstName(),p.getSecondName(),membershipNumber);
		members.add(m);
		membershipNumber++;
		return m;
	}
	public void removeMember(int memberId){
		Member m = null;
		for (Member m0: members) {
			if(m0.getMembershipNumber() == memberId)
			{
				m = m0;
			}
		}
		members.remove(m);
	}
	public void showMembers() {
		for (Member m: members) {
			m.show();
		}
	}
	public ArrayList<Member> getMembers() {
		return (ArrayList<Member>)members.clone();
	}
	//start of using hashmap
	public HashMap<String,Facility> facilityMember = new HashMap<String,Facility>();
	
	public Facility getFacility(String name)
	{
		Facility f = facilityMember.get(name);
		return f;
	}
//	Note: Array list can be converted to collection but not the other way round: (java.util.HashMap$Values cannot be cast to java.util.ArrayList)
	public ArrayList<Facility> getFacilities()
	{
		ArrayList<Facility> f = new ArrayList<Facility>();
		for (String g: facilityMember.keySet()) {
			f.add(facilityMember.get(g));
		}
		return (ArrayList<Facility>) f;
	}
	public void addFacility(Facility f)
	{
		facilityMember.put(f.getName(),f);
	}
	public void removeFacility(String name)
	{
		facilityMember.remove(name);
	}
	public void showFacilities()
	{
		for (String f: facilityMember.keySet()) {
			facilityMember.get(f).show();
		}
	}
	public void show()
	{
		showMembers();
		showFacilities();
	}
	
	BookingRegister br = new BookingRegister();
	
	public void addBooking(int mId, Facility f, LocalDateTime startDate, LocalDateTime endDate)
	{
		Member member = null;
		for(Member m: members) {
			if(m.getMembershipNumber() == mId) {
				member = m;
				break;
			}
		}
		try {
			br.addBooking(member, f, startDate, endDate);
		} catch (BadBookingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getBookings(Facility f, LocalDateTime startDate, LocalDateTime endDate) {
		ArrayList<Booking> blist = br.getBookings(f, startDate, endDate);
	}
	public void showBookings(Facility f, LocalDateTime startDate, LocalDateTime endDate) {
		ArrayList<Booking> blist = br.getBookings(f, startDate, endDate);
		for(Booking b0: blist) {
			b0.show();
		}
	}
}
