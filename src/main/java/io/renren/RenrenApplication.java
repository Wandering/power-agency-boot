package io.renren;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations={"classpath*:config/context.xml"})
@SpringBootApplication
@MapperScan(basePackages = {"io.renren.dao","com.power.dao.**.**"})
@ComponentScan(basePackages = {"com.power","io.renren"})
public class RenrenApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RenrenApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RenrenApplication.class, args);
	}
}
