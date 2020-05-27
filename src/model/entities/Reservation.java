package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
	Date now = new Date();
	
	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		if (checkin.before(now)) {
			throw new DomainException("Date must be future day");
		}
		if (!checkout.after(checkin)) {
			throw new DomainException("Check-out date must be after Check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkin, Date checkout){
		if (checkin.before(now)) {
			throw new DomainException("Date must be future day");
		}
		if (!checkout.after(checkin)) {
			throw new DomainException("Check-out date must be after Check-in date");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + " check-in " + sdf.format(checkin) + " check-out " + sdf.format(checkout) + " "
				+ duration() + " nights";
	}

}
