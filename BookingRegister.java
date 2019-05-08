package clubManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class BookingRegister {
	private HashMap<Facility,ArrayList<Booking>> bookingregister = new HashMap<Facility,ArrayList<Booking>>();
	public HashMap<Facility, ArrayList<Booking>> getBookingregister() {
		return bookingregister;
	}
	public void setBookingregister(HashMap<Facility, ArrayList<Booking>> bookingregister) {
		this.bookingregister = bookingregister;
	}
	public void addBooking(Member m, Facility f, LocalDateTime startDate, LocalDateTime endDate) throws BadBookingException {
		Booking b0 = new Booking(m, f, startDate, endDate);
		
		ArrayList<Booking> blist = bookingregister.get(f);
		
		if(blist==null)
		{
			blist = new ArrayList<Booking>();
			bookingregister.put(f,blist);
		}
		
		for (Booking b1: blist) {
			Boolean check = b1.overlaps(b0, b1);
			if(check == true) {
				throw new BadBookingException();
			}
		}
		
		blist.add(b0);
		bookingregister.get(f);
	}
	public ArrayList<Booking> getBookings(Facility f, LocalDateTime startDate, LocalDateTime endDate)
	{
		ArrayList<Booking> b1list = new ArrayList<Booking>();
		ArrayList<Booking> blist = bookingregister.get(f);
		
		for (Booking b1: blist) {
			if(b1.getStartDate().isAfter(startDate) && b1.getEndDate().isBefore(endDate)) {
				b1list.add(b1);
			}
		}
		return b1list;
	}
	public void removeBooking(Booking b2) {
		ArrayList<Booking> b2list = bookingregister.get(b2.getF());
		b2list.remove(b2);
	}
}
