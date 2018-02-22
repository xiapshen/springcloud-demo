package com.happygo.configserver.spring.schema;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * ClassName: LikabBeanDefinitionParser <br/>
 * Description: LikabBeanDefinitionParser <br/>
 * Date: 2017/12/21 16:14 <br/>
 *
 * @version 1.0 <br/>
 */
public class LikabBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    /**
     * Gets bean class.
     *
     * @param element the element
     * @return the bean class
     */
    @Override
    protected Class getBeanClass(Element element) {
        return LikabConfig.class;
    }

    /**
     * Do parse.
     *
     * @param element the element
     * @param builder the builder
     */
    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String interfaceName = element.getAttribute("interfaceName");
        String id = element.getAttribute("id");
        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        }
        if (StringUtils.hasText(interfaceName)) {
            builder.addPropertyValue("interfaceName", interfaceName);
        }
    }
}