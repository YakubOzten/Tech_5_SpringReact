package com.yakubozten.tech5;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.TimeZone;

// Mongo aktif etmek ici
// @EnableMongoRepositories

// Aspect aktif etmek icin
// @EnableAspectJAutoProxy(proxyTargetClass = true)

// Asenkron açmak icin
// @EnableAsync

// SCAN
// @EntityScan(basePackages = "com.hamitmizrak.data.entity") //Entity bulamadığı zaman
// @EnableJpaRepositories(basePackages = "com.hamitmizrak.data.repository") //Repository bulamadığı zaman

// Spring Cache aktif etmek gerekiyor.
// @EnableCaching

// Auditing Aktif etmek
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBeanMethod")

// Spring Security: Şimdilik dahil etme ancak Spring security için gerekli kütüphaneleri dahil
@SpringBootApplication(exclude = {
		//SecurityAutoConfiguration.class,
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)

// @SpringBootApplication
public class Tech5SpringReactApplication {

	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	}

	public static void main(String[] args) {

		// JOptional pane aktif etmek
		System.setProperty("java.awt.headless","false");

		// Main
		SpringApplication.run(Tech5SpringReactApplication.class, args);
	} //end main

} //end class
