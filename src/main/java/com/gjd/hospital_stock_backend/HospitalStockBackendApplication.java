package com.gjd.hospital_stock_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
@SpringBootApplication
public class HospitalStockBackendApplication {

	static void main(String[] args) {
		SpringApplication.run(HospitalStockBackendApplication.class, args);
	}

}
