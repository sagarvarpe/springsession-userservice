import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by svarpe on 21.09.17.
 */
@SpringBootApplication
@ComponentScan("com.example")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
