package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.UserService;

public class Test {

	public static void main(String[] args) {
		
		// 不用spring的方法		
		UserService s = new UserService();
		s.setName("abc");
		s.sayHello();
		
		
		// 使用spring的版本
		// root dir是 "/src/main/resources"
		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
		UserService us = (UserService) ac.getBean("userService");
		us.sayHello();		
	}

}
