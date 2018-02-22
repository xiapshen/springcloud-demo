package com.happygo.configserver.config;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;
/**
 * ClassName: SpringConfiguringClass <br/>
 * Description: SpringConfiguringClass <br/>
 * Date: 2017/12/21 10:09 <br/>
 * @version 1.0 <br/>
 */
@Profile("dev")
@Configuration
@EnableMetrics
@ImportResource("classpath:metrics-spring.xml")
public class SpringMetricsConfiguration extends MetricsConfigurerAdapter {

    @Override
    public void configureReporters(MetricRegistry metricRegistry) {
        // registerReporter allows the MetricsConfigurerAdapter to
        // shut down the reporter when the Spring context is closed
        registerReporter(ConsoleReporter
                .forRegistry(metricRegistry)
                .build())
                .start(1, TimeUnit.MINUTES);
    }
}