package ru.durnov.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import ru.durnov.dao.DeviceDaOISqlite;

import javax.servlet.ServletContext;
import java.sql.SQLException;

@Configuration
@EnableWebMvc
@ComponentScan("ru.durnov.controller")
public class WebConfig implements WebMvcConfigurer{
    private final ApplicationContext applicationContext;
    private final ServletContext servletContext;


    @Autowired
    public WebConfig(ApplicationContext applicationContext, ServletContext servletContext) {
        this.applicationContext = applicationContext;
        this.servletContext = servletContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }

    @Bean
    public DeviceDaOISqlite getDeviceDaoImpl() throws SQLException {
        DeviceDaOISqlite deviceDaO = new DeviceDaOISqlite();
        return deviceDaO;
    }

}
