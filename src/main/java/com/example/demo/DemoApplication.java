package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//최상위 컨트롤러, 그외 컨트롤러 java파일은 해당파일의 형제폴더의 자식파일에 위치해야한다. 
@SpringBootApplication
public class DemoApplication {

	//Mapping("/")이 없을 경우 boot는 static폴더의 index.html을 먼저 읽고 그 다음 templates의 "index.html"을 읽어온다. : welcome_page
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
