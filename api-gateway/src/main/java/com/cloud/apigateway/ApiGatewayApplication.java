package com.cloud.apigateway;

import com.cloud.apigateway.config.FilterConfiguration;
import com.cloud.apigateway.processor.MyFilterProcessor;
import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

/**
 * The type Api gateway application.
 */
@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //添加自定义FilterProcessor
        FilterProcessor.setProcessor(new MyFilterProcessor());
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    /**
     * Zuul properties zuul properties.
     *
     * @return the zuul properties
     */
    @Bean
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }

    /**
     * Filter loader filter loader.
     *
     * @param configuration the configuration
     * @return the filter loader
     */
    @Bean
    public FilterLoader filterLoader(FilterConfiguration configuration) {
        FilterLoader filterLoader = FilterLoader.getInstance();
        filterLoader.setCompiler(new GroovyCompiler());
        FilterFileManager.setFilenameFilter(new GroovyFileFilter());
        try {
            FilterFileManager.init(configuration.getInterval(),
                                   configuration.getRoot() + "/pre"/*,
                                   configuration.getRoot() + "/post"*/);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filterLoader;
    }
}
