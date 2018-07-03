package com.duihao.spring_boot_quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 
 *
 */
@SpringBootApplication
//@EnableScheduling
@EnableOAuth2Sso
public class QuartzApplication {
	
    public static void main( String[] args ){
    	SpringApplication.run(QuartzApplication.class, args);
    }
}
