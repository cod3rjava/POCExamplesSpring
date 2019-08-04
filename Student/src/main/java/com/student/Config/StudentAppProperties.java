package com.student.Config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "student")

@Data
public class StudentAppProperties {

	private Map<String, String> studentProps = new HashMap<String, String>();
}
