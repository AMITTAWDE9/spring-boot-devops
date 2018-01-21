package com.devops.test.config.external.props;

import com.devops.springframework.test.jms.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by at on 5/7/16.
 */
@Configuration
@PropertySource("classpath:testing.properties")
public class ExternalPropsEnvironment {

    @Autowired
    Environment env; //also from Spring 3.1

    @Bean
    public FakeJmsBroker fakeJmsBrokerEnv(){
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUrl(env.getProperty("dojo.jms.server"));
        fakeJmsBroker.setPort(env.getRequiredProperty("dojo.jms.port", Integer.class));
        fakeJmsBroker.setUser(env.getProperty("dojo.jms.user"));
        fakeJmsBroker.setPassword(env.getProperty("dojo.jms.password"));
        return fakeJmsBroker;
    }
}
