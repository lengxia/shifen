package com.jubeis.user.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ServletComponentScan("com.jubeis.common.security")
public class SecurityConfig {
}
