package gov.naco.soch.ti;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.mapstruct.ap.internal.conversion.JavaLocalDateToStringConversion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"gov.naco.soch.repository","gov.naco.soch.ti.repository"})
@EnableScheduling
@EntityScan(basePackages = {"gov.naco.soch.entity","gov.naco.soch.ti.entity"})
@ComponentScan({"gov.naco.soch.ti.mapper","gov.naco.soch"})
@PropertySource("classpath:application-${spring.profiles.active}.yml")
public class TiMicroserviceApplication extends SpringBootServletInitializer  {
	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(TiMicroserviceApplication.class);
	  }

  /**
   * Main method, used to run the application.
   *
   * @param args the command line arguments.
   */
  public static void main(String[] args) {
  	SpringApplication.run(TiMicroserviceApplication.class, args);
  } 
  
  @Bean
  public ObjectMapper objectMapper() {
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      objectMapper.registerModule(new JavaTimeModule()
              .addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
              .addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
      return objectMapper;
  }

}
