package com.edw.jergy.sample.config;

import com.edw.jergy.sample.exception.ApiException;
import com.edw.jergy.sample.filter.CORSResponseFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/*")
public class SampleConfig extends ResourceConfig {

    public SampleConfig() {
        packages("com.edw.jergy.sample.controller");
        register(CORSResponseFilter.class);
        register(ApiException.class);
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);

    }
}
