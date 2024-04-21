package com.qsp.springbootstudent1.util;

import java.util.List;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig    //documentation
{
	@Bean
    public Docket getDocket()
    {
   	 Contact contact = new Contact("Qspider","https://qspider.com" , "qspider@gmail.com");
   	 List <VendorExtension> list = new ArrayList<VendorExtension>();
   	 ApiInfo apiInfo =  new ApiInfo("Student Management", "used to manage the details of student", "version 1.0", "1 year of free service", contact," www.sms.com", " www.sms.com",list);
   	 
   	 return new Docket(DocumentationType.SWAGGER_2).select()
   			 .apis(RequestHandlerSelectors.basePackage("com.qsp.springbootstudent1"))
   			 .build().apiInfo(apiInfo)
   			 .useDefaultResponseMessages(false);
    }//for contructor pass document
}

