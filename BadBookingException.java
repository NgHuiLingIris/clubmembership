package clubManager;

public class BadBookingException extends Exception {
	public BadBookingException() {super("Bad Booking");}
	public BadBookingException(String s) {
		super (s);
	}
}
