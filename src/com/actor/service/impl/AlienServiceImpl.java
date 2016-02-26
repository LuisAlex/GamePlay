/**
 * 
 */
package com.actor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actor.Alien;
import com.actor.service.AlienService;

/**
 * @author medinach
 *
 */
@Service
public class AlienServiceImpl implements AlienService {

	@Autowired
	private Alien alien;

	public Alien getAlien(String actor) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Alien alien = (Alien) context.getBean(actor);
		return alien;
	}

}
