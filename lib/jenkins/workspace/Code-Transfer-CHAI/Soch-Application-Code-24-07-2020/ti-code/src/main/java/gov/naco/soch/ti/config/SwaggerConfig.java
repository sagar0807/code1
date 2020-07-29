package gov.naco.soch.ti.config;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Mar-11 12:34:58 pm
 * 
 */

//@Configuration
//@EnableSwagger2
//@Profile("prod")
//@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

//	public static final String AUTHORIZATION_HEADER = "Authorization";
//	public static final String DEFAULT_INCLUDE_PATTERN = "/.*";
//
//	@Bean
//	public Docket api() {
//		List<SecurityContext> securityContextList = new ArrayList<>();
//		securityContextList.add(securityContext());
//		
//		List<ApiKey> apiKeyList = new ArrayList<>();
//		ApiKey apiKey = new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
//		apiKeyList.add(apiKey);
//		
//		return new Docket(DocumentationType.SWAGGER_2)
//				.securityContexts(securityContextList)
//				.securitySchemes(apiKeyList)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("gov.naco.soch.ti.controller"))
//				.paths(PathSelectors.any())
//				.build();
//	}
//
//	private SecurityContext securityContext() {
//		return SecurityContext.builder().securityReferences(defaultAuth())
//				.forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN)).build();
//	}
//
//	List<SecurityReference> defaultAuth() {
//		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//		authorizationScopes[0] = authorizationScope;
//		List<SecurityReference> security = new ArrayList<>();
//		security.add(new SecurityReference("JWT", authorizationScopes));
//		return security;
//	}
}
