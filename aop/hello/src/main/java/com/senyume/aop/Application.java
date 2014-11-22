package com.senyume.aop;

import com.senyume.aop.aop.ExecutionTimeAdvice;
import org.aspectj.lang.Aspects;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Jigish Patel
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableAspectJAutoProxy
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
	}

	@Bean
	public ExecutionTimeAdvice executionTimeAdvice() {
		ExecutionTimeAdvice executionTimeAdvice = Aspects.aspectOf(ExecutionTimeAdvice.class);
		return executionTimeAdvice;
	}
}
