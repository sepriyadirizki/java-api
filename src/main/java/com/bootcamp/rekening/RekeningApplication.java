package com.bootcamp.rekening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.bootcamp.rekening.config.BeanConfig;


@SpringBootApplication
@Import({BeanConfig.class})
@EntityScan("com.bootcamp.rekening.model")
@EnableJpaRepositories("com.bootcamp.rekening.repository")
public class RekeningApplication {

	public static void main(String[] args) {
		SpringApplication.run(RekeningApplication.class, args);
	}

}
