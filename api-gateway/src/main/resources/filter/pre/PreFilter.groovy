package filter.pre

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext

import javax.servlet.http.HttpServletRequest

/**
 * Created by sxp on 2018/1/23.
 */
class PreFilter extends ZuulFilter {
    @Override
    String filterType() {
        return "pre"
    }

    @Override
    int filterOrder() {
        return 0
    }

    @Override
    boolean shouldFilter() {
        return true
    }

    @Override
    Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        printf "url: " + request.getRequestURL().toString()
        return null
    }
}
