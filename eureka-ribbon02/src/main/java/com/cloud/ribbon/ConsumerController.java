package com.cloud.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Consumer controller.
 */
@RestController
public class ConsumerController {

    /**
     * The Compute service.
     */
    @Autowired
    private ComputeService computeService;

    /**
     * Add string.
     *
     * @return the string
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return computeService.addService();
    }
}