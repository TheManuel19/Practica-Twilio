package utez.edu.mx.PracticaSMS;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticaSmsApplication {

	public static void main(String[] args) {

		SpringApplication.run(PracticaSmsApplication.class, args);
	}

}
