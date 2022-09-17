package com.edw.jergy.sample.config;

import com.edw.jergy.sample.controller.HomeController;
import com.edw.jergy.sample.filter.CORSResponseFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/*")
public class SampleConfig extends ResourceConfig {

    public SampleConfig() {
        packages("com.edw.jergy.sample.controller");
        register(CORSResponseFilter.class);
    }
}
