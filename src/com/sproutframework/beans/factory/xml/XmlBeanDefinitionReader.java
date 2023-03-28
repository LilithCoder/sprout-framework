package com.sproutframework.beans.factory.xml;

import com.sproutframework.beans.factory.BeanFactory;
import com.sproutframework.beans.factory.config.BeanDefinition;
import com.sproutframework.core.io.ClassPathXmlResource;
import com.sproutframework.core.io.Resource;
import org.dom4j.Element;

/**
 * xml 资源的读取解析，包括转换成 BeanDefinition，并加载到 BeanFactory
 * @author gaoweilin
 * @date 2023/03/27 Mon 11:24 PM
 */
public class XmlBeanDefinitionReader {
    private BeanFactory beanFactory;
    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 加载 Bean 的 定义到容器中
     * @param resource
     */
    public void loadBeanDefinitions(ClassPathXmlResource resource) {
        while (resource.hasNext()) {
            Element element = resource.next();
            String id = element.attributeValue("id");
            String clazzName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(id, clazzName);
            this.beanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}
