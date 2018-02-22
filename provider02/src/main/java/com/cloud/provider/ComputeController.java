package com.cloud.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Compute controller.
 */
@RestController
public class ComputeController {

    /**
     * The Client.
     */
    @Autowired
    private DiscoveryClient client;

    /**
     * Add integer.
     *
     * @param a the a
     * @param b the b
     * @return the integer
     */
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        Integer r = a + b;
        System.out.printf("provider01 invoke, result is "  + r);
        return r;
    }
}