package com.livarter.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author : 황수영
 * @fileName : AopConfig
 * @since : 2024-01-20
 * 내용 : 로그용 AOP
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.livarter.app")
public class AopConfig {
}