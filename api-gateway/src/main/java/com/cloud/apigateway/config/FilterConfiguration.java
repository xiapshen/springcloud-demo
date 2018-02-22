package com.cloud.apigateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: ApigatewayConfig <br/>
 * Description: ApigatewayConfig <br/>
 * Date: 2018/1/22 16:37 <br/>
 *
 * @version 1.0 <br/>
 */
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "zuul.filter")
public class FilterConfiguration {

    /**
     * The Root.
     */
    private String root;

    /**
     * The Interval.
     */
    private int interval;

    /**
     * Gets root.
     *
     * @return the root
     */
    public String getRoot() {
        return root;
    }

    /**
     * Sets root.
     *
     * @param root the root
     */
    public void setRoot(String root) {
        this.root = root;
    }

    /**
     * Gets interval.
     *
     * @return the interval
     */
    public int getInterval() {
        return interval;
    }

    /**
     * Sets interval.
     *
     * @param interval the interval
     */
    public void setInterval(int interval) {
        this.interval = interval;
    }
}