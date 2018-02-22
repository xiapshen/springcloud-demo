package com.cloud.apigateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: TestConfiguration <br/>
 * Description: TestConfiguration <br/>
 * Date: 2018/1/24 16:06 <br/>
 * @version 1.0 <br/>
 */
@Configuration
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix = "zuul")
public class TestConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(TestConfiguration.class);

    private Map<String, String> superHost = new HashMap<>();

    public Map<String, String> getSuperHost() {
        return superHost;
    }

    public void setSuperHost(Map<String, String> superHost) {
        this.superHost = superHost;
    }

    @PostConstruct
    public void init () {
        logger.info(superHost.isEmpty() + "");
    }
}