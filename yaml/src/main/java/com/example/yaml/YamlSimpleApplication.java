package com.example.yaml;

import com.example.yaml.config.GlobalProperties;
import com.example.yaml.config.WordPressProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class YamlSimpleApplication implements CommandLineRunner {
	@Autowired
	private WordPressProperties wpProperties;
	@Autowired
	private GlobalProperties globalProperties;
	public static void main(String[] args) {
		SpringApplication.run(YamlSimpleApplication.class, args);
	}
	@Override
	public void run(String... args) {
		System.out.println(globalProperties);
		System.out.println(wpProperties);
	}
}
