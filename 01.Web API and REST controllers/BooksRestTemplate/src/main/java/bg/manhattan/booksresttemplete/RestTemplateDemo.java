package bg.manhattan.booksresttemplete;

import bg.manhattan.booksresttemplete.model.dto.BookDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class RestTemplateDemo implements CommandLineRunner {
    private final RestTemplate restTemplate;

    public RestTemplateDemo(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        ResponseEntity<BookDTO[]> responseEntity = this.restTemplate.getForEntity("http://localhost:8080/api/books",
                BookDTO[].class);
        if (responseEntity.hasBody()){
            Arrays.stream(responseEntity.getBody())
                    .forEach(bookDTO -> System.out.println(bookDTO));

        }

    }
}
