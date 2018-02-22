package com.cloud.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * The type Compute service.
 */
@Service
public class ComputeService {

    /**
     * The Rest template.
     */
    @Autowired
    RestTemplate restTemplate;

    /**
     * Add service string.
     *
     * @return the string
     */
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://compute-service/add?a=10&b=20", String.class).getBody();
    }

    /**
     * Add service fallback string.
     *
     * @return the string
     */
    public String addServiceFallback() {
        return "error";
    }
}