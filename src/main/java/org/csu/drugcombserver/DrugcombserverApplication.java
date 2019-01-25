package org.csu.drugcombserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= "org.csu.drugcombserver.mapper")
public class DrugcombserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugcombserverApplication.class, args);
	}

}

