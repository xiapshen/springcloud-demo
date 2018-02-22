package com.happygo.configserver.spring.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * ClassName: LikabNamespaceHandler <br/>
 * Description: LikabNamespaceHandler <br/>
 * Date: 2017/12/21 16:12 <br/>
 *
 * @version 1.0 <br/>
 */
public class LikabNamespaceHandler extends NamespaceHandlerSupport {

    /**
     * Init.
     */
    @Override
    public void init() {
        registerBeanDefinitionParser("interface", new LikabBeanDefinitionParser());
    }
}