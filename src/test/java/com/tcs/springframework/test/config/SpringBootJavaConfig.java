package com.tcs.springframework.test.config;

import com.tcs.springframework.test.jms.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by at on 5/7/16.
 */
@Configuration
public class SpringBootJavaConfig {
    @Value("${dojo.jms.server}")
    String jmsServer;

    @Value("${dojo.jms.port}")
    Integer jmsPort;

    @Value("${dojo.jms.user}")
    String jmsUser;

    @Value("${dojo.jms.password}")
    String jmsPassword;

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
