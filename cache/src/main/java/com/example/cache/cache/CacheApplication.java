package com.example.cache.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableCaching
public class CacheApplication implements CommandLineRunner {

	@Autowired
	CacheService cacheService;

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		cacheService.saveData(new DataMetaData("b","2"));
		System.out.println(cacheService.getData("b").getName());
		cacheService.deleteData("b");
//		Thread.sleep(5000);
		System.out.println(cacheService.getData("b").getName());
	}
}
