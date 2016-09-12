package net.the_wyvern.code.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@EnableScheduling
@ComponentScan({
        "net.the_wyvern.code.init"
})
public class MvcConfig extends WebMvcConfigurationSupport
{
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/content/**").addResourceLocations("/resources/content/");
    }

    @Bean
    public TilesConfigurer setupTilesConfigurer()
    {
        TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[]{"/WEB-INF/views.xml"});
        return configurer;
    }

    @Bean
    public UrlBasedViewResolver setupTilesViewResolver()
    {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(TilesView.class);
        return viewResolver;
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter()
    {
        // Stop model attributes being appended to the end of redirects
        RequestMappingHandlerAdapter adapter = super.requestMappingHandlerAdapter();
        adapter.setIgnoreDefaultModelOnRedirect(true);

        // Needed for resources to work; this pretty much replaces EnableWebMvc annotation, along with
        // extending WebMvcConfigurationSupport
        // -- Not entirely sure what this means/does, will need to look later...
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) adapter.getWebBindingInitializer();
        initializer.setDirectFieldAccess(true);

        return adapter;
    }

}
