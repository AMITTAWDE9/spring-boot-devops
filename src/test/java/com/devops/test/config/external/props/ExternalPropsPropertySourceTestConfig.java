package com.devops.test.config.external.props;

import com.devops.springframework.test.jms.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * since Spring 3.1
 * Created by at on 5/7/16.
 */
@Configuration
@PropertySource("classpath:testing.properties")
public class ExternalPropsPropertySourceTestConfig {

    @Value("${dojo.jms.server}")
    String jmsServer;

    @Value("${dojo.jms.port}")
    Integer jmsPort;

    @Value("${dojo.jms.user}")
    String jmsUser;

    @Value("${dojo.jms.password}")
    String jmsPassword;


    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer
                = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUrl(jmsServer);
        fakeJmsBroker.setPort(jmsPort);
        fakeJmsBroker.setUser(jmsUser);
        fakeJmsBroker.setPassword(jmsPassword);
        return fakeJmsBroker;
    }
}
