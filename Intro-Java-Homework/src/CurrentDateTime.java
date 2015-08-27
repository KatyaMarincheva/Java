import java.time.Instant;
import java.time.LocalDateTime;
import java.text.MessageFormat;
import java.time.ZoneId;

public class CurrentDateTime {
public static void main(String[] args) {
	 
	LocalDateTime dt = LocalDateTime.now(ZoneId.of("Europe/Sofia"));
	System.out.println(dt);
	
	System.out.printf("now: %s%n", LocalDateTime.now());

	System.out.printf("now (from Instant): %s%n",
	                  LocalDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Sofia")));
	
	System.out.println(MessageFormat.format("now: {0}", LocalDateTime.now()));
	
	System.out.println(String.format("now: %s", LocalDateTime.now()));
}
}
