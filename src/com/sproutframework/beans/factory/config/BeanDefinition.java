package com.sproutframework.beans.factory.config;

/**
 * Bean 的定义
 * @author gaoweilin
 * @date 2023/03/26 Sun 7:31 PM
 */
public class BeanDefinition {
    /** Bean 的唯一标识符 */
    private String id;
    /** Bean 的类全路径名 */
    private String className;

    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
