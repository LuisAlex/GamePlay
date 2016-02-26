package com.actor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


import com.actor.Robot;
import com.actor.service.RobotService;

@Service
public class RobotServiceImpl implements RobotService {
	
@Autowired
private Robot robot;


	@Override
	public Robot getRobot(String actor) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Robot robot = (Robot) context.getBean(actor);
		return robot;
	}

}
