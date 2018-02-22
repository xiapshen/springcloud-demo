package com.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The type Cloud provider application.
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class CloudProviderApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(CloudProviderApplication.class, args);
	}
}
