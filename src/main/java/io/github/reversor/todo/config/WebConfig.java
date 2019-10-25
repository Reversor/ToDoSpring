package io.github.reversor.todo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "io.github.reversor.todo.controller")
public class WebConfig {
}
