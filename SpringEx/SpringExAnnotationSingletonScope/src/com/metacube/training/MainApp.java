package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		Person person1 = (Person) context.getBean("person");
		person1.showName();
		person1.setName("arjita");
		person1.showName();
		Person person2 = (Person) context.getBean("person");
		person2.showName();
	}
}
