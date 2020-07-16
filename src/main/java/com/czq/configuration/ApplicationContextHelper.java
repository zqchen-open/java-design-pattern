package com.czq.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 注意：@SpringBootTest 单元测试
 * @Test单元测试
 * @RunWith(SpringRunner.class)
 * @SpringBootTest(classes = JavaDesignPatternApplication.class) 必须指向启动类，否则不会执行ApplicationContextAware接口setApplicationContext方法
 */
@Component
@Lazy(false)
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHelper.applicationContext = applicationContext;
    }


    public static Object getBean(String name) {
        return applicationContext != null ? applicationContext.getBean(name) : null;
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext != null ? applicationContext.getBean(clazz) : null;
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext != null ? applicationContext.getBean(name, clazz) : null;
    }
}
