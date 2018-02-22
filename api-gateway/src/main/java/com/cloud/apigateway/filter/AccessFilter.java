package com.cloud.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Access filter.
 */
@Component
public class AccessFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * Filter type string.
     *
     * @return the string
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * Filter order int.
     *
     * @return the int
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * Should filter boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * Run object.
     *
     * @return the object
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info("send " + request.getMethod() + " request to " + request.getRequestURI().toString());
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            logger.info("warn:access token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("401, Unauthorized");
            return null;
        }
        logger.info("access token ok");
        return null;
    }
}