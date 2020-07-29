package gov.naco.soch.cst;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

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

import gov.naco.soch.util.CommonConstants;

@SpringBootApplication
@EnableJpaRepositories("gov.naco.soch.repository")
@EnableAsync
@EntityScan("gov.naco.soch.entity")
@ComponentScan(basePackages = { "gov.naco.soch" })
@PropertySource("classpath:application-${spring.profiles.active}.yml")
public class CstServiceApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CstServiceApplication.class);
	}

	/**
	 * Main method, used to run the application.
	 *
	 * @param args
	 *            the command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(CstServiceApplication.class, args);
	}

	/*
	 * created_time, modified_time time values should be saved in UTC timezone
	 * values, using '@CreatedDate' and '@LastModifiedDate' in Auditable class.
	 */
	@PostConstruct
	public void setTimeZone() {
		TimeZone.setDefault(TimeZone.getTimeZone(CommonConstants.TIMEZONE_IST));
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
