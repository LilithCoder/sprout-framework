package com.sproutframework.beans.factory;

import com.sproutframework.beans.BeansException;
import com.sproutframework.beans.factory.config.BeanDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaoweilin
 * @date 2023/03/27 Mon 11:43 PM
 */
public class SimpleBeanFactory implements BeanFactory {
    /** 单例 Bean 对象的缓存：bean name 和 Bean 对象的映射 */
    private Map<String, Object> singletonObjects = new HashMap<>();

    /** Bean name 和 BeanDefinition 的映射 */
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 根据 Bean 名称从容器获取 Bean 实例
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = singletonObjects.get(name);

        if (bean == null) {
            if (beanDefinitionMap.containsKey(name)) {
                BeanDefinition beanDefinition = beanDefinitionMap.get(name);
                try {
                    bean = Class.forName(beanDefinition.getClassName()).newInstance();
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                singletonObjects.put(beanDefinition.getId(), bean);
            } else {
                throw new BeansException("Cannot find the Bean name:[" + name + "]");
            }
        }
        return bean;
    }

    /**
     * 注册 Bean 定义到容器中
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(beanDefinition.getId(), beanDefinition);
    }
}
