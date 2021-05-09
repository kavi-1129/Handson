package com.cognizant.truyum;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/cognizant/truyum/spring-config.xml");
		Object menuList = context.getBean("menuItems");
		System.out.println(menuList);
	}

}
