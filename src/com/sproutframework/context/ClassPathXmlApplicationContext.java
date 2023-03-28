package com.sproutframework.context;

import com.sproutframework.beans.BeansException;
import com.sproutframework.beans.factory.BeanFactory;
import com.sproutframework.beans.factory.SimpleBeanFactory;
import com.sproutframework.beans.factory.config.BeanDefinition;
import com.sproutframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.sproutframework.core.io.ClassPathXmlResource;
import com.sproutframework.core.io.Resource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaoweilin
 * @date 2023/03/26 Sun 8:51 PM
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
    private BeanFactory beanFactory;

    /**
     * 容器启动过程：读 xml 配置文件，解析 Bean 的定义，创建 BeanFactory
     * @param fileName
     */
    public ClassPathXmlApplicationContext(String fileName) {
        ClassPathXmlResource resource = new ClassPathXmlResource(fileName);
        this.beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this.beanFactory);
        reader.loadBeanDefinitions(resource);
    }

    /**
     * 从容器获取 Bean 实例
     * @param beanName
     * @return
     */
    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    /**
     * 注册 Bean 定义到容器中
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }
}
