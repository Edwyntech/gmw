package tech.edwyn.gmw.infra;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "GMW API", version = "1.0"))
public class GMWApplication {
    public static void main(String[] args) {
        SpringApplication.run(GMWApplication.class, args);
    }
}