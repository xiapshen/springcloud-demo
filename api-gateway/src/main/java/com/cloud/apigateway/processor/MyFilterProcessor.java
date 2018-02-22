package com.cloud.apigateway.processor;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * ClassName: MyFilterProcessor <br/>
 * Description: MyFilterProcessor <br/>
 * Date: 2018/1/22 15:30 <br/>
 * @version 1.0 <br/>
 */
public class MyFilterProcessor extends FilterProcessor {

    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        return super.processZuulFilter(filter);
    }
}