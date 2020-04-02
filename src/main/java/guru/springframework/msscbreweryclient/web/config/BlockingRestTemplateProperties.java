package guru.springframework.msscbreweryclient.web.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("blocking-template")
public class BlockingRestTemplateProperties {
    private String connectionManagerMaxTotal;
    private String connectionManagerDefaultMaxPerRoute;
    private String connectionRequestTimeout;
    private String socketTimeout;
}
