package net.thewyvern.webapp.ec2.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;  
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.web.WebApplicationInitializer;  
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;  
import org.springframework.web.servlet.DispatcherServlet;  
  
public class Initializer extends AbstractHttpSessionApplicationInitializer implements WebApplicationInitializer {  
      
	
	public Initializer() {
		super(RedisConfig.class);
	}
	
    @Override  
    public void onStartup(ServletContext servletContext) throws ServletException {  

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
          
        ctx.setServletContext(servletContext);    
          
        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
        servlet.addMapping("/");  
        servlet.setLoadOnStartup(1);  
    }
  
} 