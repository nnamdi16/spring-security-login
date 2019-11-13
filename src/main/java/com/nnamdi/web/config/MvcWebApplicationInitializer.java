package com.nnamdi.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Programmatically configuring ServletContext making web.xml not required.
 * AbstractAnnotationConfigDispatcherServletInitializer implement WebApplicationInitializer which configures servletContext
 */

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //Loads spring security configuration
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {WebSecurityConfig.class};
    }

    //Loads spring web configuration
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }


    //
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
