package com.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import zipkin.server.EnableZipkinServer;
import zipkin.storage.mysql.MySQLStorage;

import javax.sql.DataSource;

/**
 * The type Zipkin server application.
 */
@EnableZipkinServer
@SpringBootApplication
public class ZipkinServerApplication {

	/**
	 * My sql storage my sql storage.
	 *
	 * @param datasource the datasource
	 * @return the my sql storage
	 */
	@Bean
	public MySQLStorage mySQLStorage(DataSource datasource) {
		return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
	}

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
}
