package com.cloud.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Compute controller.
 */
@RestController
public class ComputeController {

    private static final Logger logger = LoggerFactory.getLogger(ComputeController.class);

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
    public Integer add(HttpServletRequest request, @RequestParam Integer a, @RequestParam Integer b) {
        Integer r = a + b;
        logger.info("====<call ribbon-consumer01 TraceId={}, SpanId={}>====", request.getHeader("X-B3-TraceId"),
                request.getHeader("X-B3-SpanId"));
        logger.info("provider01 invoke, result is " + r);
        return r;
    }
}