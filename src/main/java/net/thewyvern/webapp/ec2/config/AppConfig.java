package net.thewyvern.webapp.ec2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        PropertiesConfig.class
})
@ComponentScan({
        "net.thewyvern.webapp.ec2.config"
})
public class AppConfig
{
}
