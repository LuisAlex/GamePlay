package com.actor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.actor.Human;
import com.actor.service.HumanService;

@Service
public class HumanServiceImpl implements HumanService 
{

	@Autowired
	private Human human;

	public Human getHuman(String actor) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Human human = (Human) context.getBean(actor);
		return human;
	}

}
