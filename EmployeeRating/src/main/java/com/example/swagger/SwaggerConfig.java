package com.example.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration 
public class SwaggerConfig {
   @Bean
   public OpenAPI awesomeAPI() {
      // custom swagger configurations  
        return new OpenAPI()
                .info(new Info().title("EmployeeRatingAPI")
                        .description("EmployeeRatingAPI Endpoints information")
                        .version("1.0"))
                        .externalDocs(new ExternalDocumentation()
                        .description("Ganesh, ganesh.repalle949@gmail.com")
                  );
   }
    
}

