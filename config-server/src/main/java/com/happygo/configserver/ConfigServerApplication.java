package com.happygo.configserver;

import com.happygo.configserver.spring.schema.LikabConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ApplicationContext;

/**
 * The type Config server application.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(ConfigServerApplication.class, args);

		LikabConfig likabConfig = ac.getBean(LikabConfig.class);
		System.out.println(">>>>>>>>" + String.format("LikabConfig[id:%s, interfaceName:%s]",
						likabConfig.getId(), likabConfig.getInterfaceName()));
	}
}