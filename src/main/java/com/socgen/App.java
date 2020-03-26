package com.socgen;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"com.socgen.*"})
public class App 
{
    public static void main( String[] args )
    {
      SpringApplication.run(App.class, args);
    }
    
  @Bean
    public Docket api() {
    	
    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
    .paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndPointsInfo());
  //  .globalOperationParameters(parameters).securityContexts(Lists.newArrayList(securityContext()))
  // .securitySchemes(Lists.newArrayList(apiKey()));
    
    }

    private ApiInfo apiEndPointsInfo() {
    return new ApiInfoBuilder().title("EMPLOYEE PORTAL").description("Employee Portal").version("1.0.0").build();
    }
    
   /* private ApiKey apiKey() {
    	return new ApiKey("JWT", "Authorization", "header");
    	}

    	private SecurityContext securityContext() {
    	return SecurityContext.builder()
    	.securityReferences(defaultAuth())
    	.forPaths(PathSelectors.regex("/ep/.*"))
    	.build();
    	}

    	private List<SecurityReference> defaultAuth() {
    	AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    	AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    	authorizationScopes[0] = authorizationScope;
    	return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
    	}
*/
   /* @Bean
    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
        HibernateJpaSessionFactoryBean fact = new HibernateJpaSessionFactoryBean();
        fact.setEntityManagerFactory(emf);
        return fact;
    }*/
}
