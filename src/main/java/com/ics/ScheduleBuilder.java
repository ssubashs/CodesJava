package com.ics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Dur;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.ValidationException;
import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.property.Action;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.UidGenerator;

import org.junit.Test;

public class ScheduleBuilder {
	TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
	TimeZone timezone = registry.getTimeZone("America/Los_Angeles");
	VTimeZone tz = timezone.getVTimeZone();
	
	
	private class Game{
		private DateTime gamedate;
		private String ground;
		private String opponent;
		
		public Game(String MMddyy, String ground, String opponent) {
			super();
			this.setGamedate(MMddyy);
			this.ground = ground;
			this.opponent = opponent;
		}
		
		public DateTime getGamedate() {
			return gamedate;
		}
		
		public void setGamedate(String MMddyy) {
			
			DateFormat  formatter = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
	        try {
	        	java.util.Date convertedDate = (java.util.Date) formatter.parse(MMddyy+" 10:00:00");				
				this.gamedate = new DateTime(convertedDate);
				gamedate.setTimeZone(timezone);
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public String getGround() {
			return ground;
		}
		public void setGround(String ground) {
			this.ground = ground;
		}
		public String getOpponent() {
			return opponent;
		}
		public void setOpponent(String opponent) {
			this.opponent = opponent;
		}
		
		
		
	}
	
	public Game[] victoriagames = new Game[] {
			new Game("04/19/15","Woodlie Park - Wong","United"),
			new Game("04/26/15","Smith Murphy","San Diego1"),
			new Game("05/02/15","Woodlie Park - Marder","Bengals"),
			new Game("05/09/15","Smith Murphy","CSUF"),
			new Game("05/17/15","Highland 1","Pasadena2"),
			new Game("06/21/15","Woodlie Park - Wright","Ventura"),
			new Game("06/27/15","Woodlie Park - Wright","Inland Empire1"),
			new Game("07/26/15","Woodlie Park - Wong","Britamer"),
			new Game("08/02/15","Smith Murphy","Cougars"),
			new Game("08/15/15","Smith Murphy","University"),
			new Game("08/29/15","Woodlie Park - Wright","Hollywood2")				
			};
	
	
	public VEvent getEvent(Game game)
	{
		Dur duration = new Dur(0,8,0,0);
		VEvent meeting = new VEvent(game.getGamedate(),duration,"Victoria vs "+game.getOpponent() +" :: "+game.getGround()); 
		
		// Create a TimeZone
				
		// add timezone info..
				meeting.getProperties().add(tz.getTimeZoneId());

				// generate unique identifier..
				UidGenerator ug;
				try {
					ug = new UidGenerator("uidGen");
					Uid uid = ug.generateUid();
					meeting.getProperties().add(uid);
				} catch (SocketException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				VAlarm onehrreminder = new VAlarm(new Dur(0,-1,0,0));				
				// display a message..
				onehrreminder.getProperties().add(Action.DISPLAY);
				onehrreminder.getProperties().add(new Description("Get ready for "+"Victoria vs "+game.getOpponent() +" :: "+game.getGround()));				
				meeting.getAlarms().add(onehrreminder);
				
				VAlarm onedayreminder = new VAlarm(new Dur(0,-13,0,0));				
				// display a message..
				onedayreminder.getProperties().add(Action.DISPLAY);
				onedayreminder.getProperties().add(new Description("Gentle remainder for tomorrow's game "+"Victoria vs "+game.getOpponent()));
				meeting.getAlarms().add(onedayreminder);
				
		return meeting;
	}
	
	@Test
	public void buildCricketSchedule()
	{
		
		// Create a TimeZone
		TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
		TimeZone timezone = registry.getTimeZone("America/Los_Angeles");
		VTimeZone tz = timezone.getVTimeZone();

		 // Start Date is on: April 1, 2008, 9:00 am
		java.util.Calendar startDate = new GregorianCalendar();
//		startDate.setTimeZone(timezone);
//		startDate.set(java.util.Calendar.MONTH, java.util.Calendar.APRIL);
//		startDate.set(java.util.Calendar.DAY_OF_MONTH, 1);
//		startDate.set(java.util.Calendar.YEAR, 2008);
//		startDate.set(java.util.Calendar.HOUR_OF_DAY, 9);
//		startDate.set(java.util.Calendar.MINUTE, 0);
//		startDate.set(java.util.Calendar.SECOND, 0);

		 // End Date is on: April 1, 2008, 13:00
		java.util.Calendar endDate = new GregorianCalendar();
//		endDate.setTimeZone(timezone);
//		endDate.set(java.util.Calendar.MONTH, java.util.Calendar.APRIL);
//		endDate.set(java.util.Calendar.DAY_OF_MONTH, 1);
//		endDate.set(java.util.Calendar.YEAR, 2008);
//		endDate.set(java.util.Calendar.HOUR_OF_DAY, 13);
//		endDate.set(java.util.Calendar.MINUTE, 0);	
//		endDate.set(java.util.Calendar.SECOND, 0);

		// Create the event
//		String eventName = "Progress Meeting";
//		DateTime start = new DateTime(startDate.getTime());
//		DateTime end = new DateTime(endDate.getTime());
//		VEvent meeting = new VEvent(start, end, eventName);

		// add timezone info..
//		meeting.getProperties().add(tz.getTimeZoneId());

		// generate unique identifier..
//		UidGenerator ug;
//		try {
//			ug = new UidGenerator("uidGen");
//			Uid uid = ug.generateUid();
//			meeting.getProperties().add(uid);
//		} catch (SocketException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		

//		// add attendees..
//		Attendee dev1 = new Attendee(URI.create("mailto:dev1@mycompany.com"));
//		dev1.getParameters().add(Role.REQ_PARTICIPANT);
//		dev1.getParameters().add(new Cn("Developer 1"));
//		meeting.getProperties().add(dev1);
//
//		Attendee dev2 = new Attendee(URI.create("mailto:dev2@mycompany.com"));
//		dev2.getParameters().add(Role.OPT_PARTICIPANT);
//		dev2.getParameters().add(new Cn("Developer 2"));
//		meeting.getProperties().add(dev2);

		// Create a calendar
		net.fortuna.ical4j.model.Calendar icsCalendar = new net.fortuna.ical4j.model.Calendar();
		icsCalendar.getProperties().add(new ProdId("-//Victoria Calendar 2015//SCCA//EN"));
		icsCalendar.getProperties().add(CalScale.GREGORIAN);
		icsCalendar.getProperties().add(Version.VERSION_2_0);
		//VERSION:2.0


		// Add the event and print
		for(Game game: victoriagames)
		{
			icsCalendar.getComponents().add(this.getEvent(game));			
		}
//		icsCalendar.getComponents().add(meeting);
		System.out.println(icsCalendar);

		FileOutputStream fout;
		try {
			
			
			File file = new File("C:/Users/uswbdnu/git/ssubashs/CodesJava/src/main/resources/ics/mycalendar.ics");
			fout = new FileOutputStream(file);
			CalendarOutputter outputter = new CalendarOutputter();
			outputter.output(icsCalendar, fout);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}

}
