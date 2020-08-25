package ru.durnov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.durnov.config.SpringConfig;
import ru.durnov.service.TestBean;

public class SiteApp {
    public static void main(String[] args){
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        TestBean testBean = (TestBean) configApplicationContext.getBean(TestBean.class);
        System.out.println(testBean.getName());
    }
}
