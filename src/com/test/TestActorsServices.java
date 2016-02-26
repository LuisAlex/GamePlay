package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.actor.Alien;
import com.actor.Human;
import com.actor.Robot;
import com.actor.service.impl.AlienServiceImpl;
import com.actor.service.impl.HumanServiceImpl;
import com.actor.service.impl.RobotServiceImpl;


public class TestActorsServices
{

	@Autowired
	private AlienServiceImpl alienService; 
	@Autowired
	private HumanServiceImpl humanService;
	@Autowired
	private RobotServiceImpl robotService;
	
	
	  @Test
	  public void TestAlienService() {
		  Alien alien = new AlienServiceImpl().getAlien("alien");
		  assertNotNull("Should be an Alien", alien);
		  assertEquals(14, alien.getHealth());
		  assertEquals("Alien", alien.getNombre());		  
	      System.out.println("@Test - testing Alien Service");
	  }
	  
	  
	  @Test
	  public void TestHumanService() {
		  Human human = new HumanServiceImpl().getHuman("human");
		  assertNotNull("Should be an Alien", human);
		  assertEquals(16, human.getHealth());
		  assertEquals("Human", human.getNombre());		  
	      System.out.println("@Test - testing Human Service");
	  }
	  
	  @Test
	  public void TestRobotService() {
		  Robot robot = new RobotServiceImpl().getRobot("robot");
		  assertNotNull("Should be an Alien", robot);
		  assertEquals(14, robot.getHealth());
		  assertEquals("Robot", robot.getNombre());		  
	      System.out.println("@Test - testing Robot Service");
	  }
}
