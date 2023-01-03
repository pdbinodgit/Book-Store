package com.bookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);

		StringBuffer sb=new StringBuffer("Hello ");
		sb.append("ram");//now original string is changed
		System.out.println(sb);//prints Hello Java




}

}
