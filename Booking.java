package clubManager;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Booking {
	private Member m;
	private Facility f;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	public Member getM() {
		return m;
	}
	public void setM(Member m) {
		this.m = m;
	}
	public Facility getF() {
		return f;
	}
	public void setF(Facility f) {
		this.f = f;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	public Booking(Member m, Facility f, LocalDateTime startDate, LocalDateTime endDate) throws BadBookingException
	{
		if(m == null||f==null||startDate==null||endDate==null) throw new BadBookingException();
		this.m = m;
		this.f = f;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public boolean overlaps(Booking b0, Booking b1)
	{
		if(b0==b1)
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	public String toString()
	{
//		DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
		String s = "";
		s = "Member: "+m+"\nFacility: "+f+"\nStart Date: "+startDate+"\nEnd Date: "+endDate;
		return s;
	}
	public void show()
	{
		System.out.println(toString());
	}
}
