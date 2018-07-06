package simpleDateFormatThreadSafeExample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormatUnSafetyExample {
	
	
	
	public static void main(String[] args) {
		
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" yyy-MM-dd'T'HH:MM:ss");
		final String text=date.format(formatter );
		
		//LocalDate parseDate=LocalDate.parse(text, formatter);
		//final String dateStr =" 2018-06-22T10:00:00";
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		Runnable task = new Runnable() {
			
			public void run() {
				
				parseDate( text);
				
			}

			
		};
		
		for( int i=0; i<100; i++) {
			
			executorService.submit(task);
		}
		
		executorService.shutdown();
	}
	
	private synchronized static void parseDate(String dateStr) {
		
		
		try {
			SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss");
			Date date = simpleDateFormat.parse(dateStr);
			
			System.out.println("Succefully parsed date" + date);
			
		} catch (ParseException e) {
			
			System.out.println("ErrorParse date: " + e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
