package com.nnamdi.web.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 *
 * Spring security will be implemented using DelegateFilterProxy
 * To register it with the Spring container it will extend AbstractSecurityWebApplicationInitializer.It enables Spring to register DelegatingFileProxy and use the springSecurityFilterChain filter
 *
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
