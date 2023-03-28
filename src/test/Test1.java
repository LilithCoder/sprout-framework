package test;

import com.sproutframework.beans.BeansException;
import com.sproutframework.context.ClassPathXmlApplicationContext;
import test.service.AService;

/*
 * @author gaoweilin
 * @date 2023/03/27 Mon 10:18 AM
 */
public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AService aservice = null;
        try {
            aservice = (AService) ctx.getBean("aservice");
        } catch (BeansException e) {
            e.printStackTrace();
        }
        if (aservice != null) {
            aservice.invoke();
        }
    }
}
