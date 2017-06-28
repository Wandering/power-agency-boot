package io.renren;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"io.renren.dao","com.power.dao.**.**"})
@ComponentScan(basePackages = {"com.power","io.renren"})
public class RenrenApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenrenApplication.class, args);
	}
}
