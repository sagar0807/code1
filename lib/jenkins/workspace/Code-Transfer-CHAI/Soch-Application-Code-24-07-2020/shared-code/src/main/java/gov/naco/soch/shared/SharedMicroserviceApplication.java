package gov.naco.soch.shared;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories("gov.naco.soch.repository")
@EnableAsync
@EntityScan("gov.naco.soch.entity")
@ComponentScan({"gov.naco.soch.shared.mapper","gov.naco.soch"})
@PropertySource("classpath:application-${spring.profiles.active}.yml")
public class SharedMicroserviceApplication extends SpringBootServletInitializer {@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(SharedMicroserviceApplication.class);
  }

/**
 * Main method, used to run the application.
 *
 * @param args the command line arguments.
 */
public static void main(String[] args) {
	SpringApplication.run(SharedMicroserviceApplication.class, args);
} 

@Bean
public RestTemplate getRestTemplate()
{
	return new RestTemplate();
}

}
