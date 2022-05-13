package br.com.alura.oobj.easybill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EasyBillApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyBillApplication.class, args);
	}
}
