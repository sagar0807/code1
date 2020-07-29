package gov.naco.soch.lab;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import gov.naco.soch.util.CommonConstants;

@SpringBootApplication
@EnableJpaRepositories("gov.naco.soch.repository")
@EntityScan("gov.naco.soch.entity")
@ComponentScan(basePackages = { "gov.naco.soch" })
@PropertySource("classpath:application-${spring.profiles.active}.yml")
public class LabServiceApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LabServiceApplication.class);
	}

	/**
	 * Main method, used to run the application.
	 *
	 * @param args the command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(LabServiceApplication.class, args);
	}

	@PostConstruct
	public void setTimeZone() {
		TimeZone.setDefault(TimeZone.getTimeZone(CommonConstants.TIMEZONE_IST));
	}
}
