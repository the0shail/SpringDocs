package the.zero.shail.sender;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import the.zero.shail.sender.listeners.Listener;

@SpringBootApplication
public class SenderApplication {
	private final Listener listener;

	@Autowired
    public SenderApplication(Listener listener) {
        this.listener = listener;
    }

    public static void main(String[] args) {
		SpringApplication.run(SenderApplication.class, args);
	}

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.registerModule(new JavaTimeModule());
    }
}
