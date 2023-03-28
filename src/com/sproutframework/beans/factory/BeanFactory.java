package com.sproutframework.beans.factory;

import com.sproutframework.beans.factory.config.BeanDefinition;
import com.sproutframework.beans.BeansException;

/**
 * Bean 容器最基础的接口
 * @author gaoweilin
 * @date 2023/03/27 Mon 10:38 PM
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
    void registerBeanDefinition(BeanDefinition beanDefinition);
}
