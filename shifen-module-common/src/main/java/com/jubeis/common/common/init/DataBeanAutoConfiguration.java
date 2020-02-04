package com.jubeis.common.common.init;

import com.jubeis.model.common.dos.DistributedIdGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;



@SpringBootConfiguration
public class DataBeanAutoConfiguration {

    @Value("${common.serviceId}")
    private Long serviceId;
    @Value("${common.instanceId}")
    private Long instanceId;

    @Bean
    public DistributedIdGenerator distributedIdGenerator() {
        return new DistributedIdGenerator(serviceId, instanceId);
    }
}
