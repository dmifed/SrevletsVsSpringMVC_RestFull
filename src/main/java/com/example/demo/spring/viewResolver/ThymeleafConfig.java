package com.example.demo.spring.viewResolver;

import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


/**
 * @author dmifed
 */
public class ThymeleafConfig {

    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
/*        templateResolver.setPrefix("classpath:/templates");
        System.out.println(templateResolver.getPrefix());
        templateResolver.setSuffix(".html");*/

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return viewResolver;


    }
}
