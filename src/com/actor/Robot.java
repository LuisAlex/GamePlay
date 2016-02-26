package com.actor;

import org.springframework.stereotype.Component;

@Component("robot")
public class Robot
{
	
	private int Health = 14;
	private String nombre = "Robot";
	
	public Robot() {}
	
	public int getHealth() 
	{
		return Health;
	}
	
	public void setHealth(int health) 
	{
		Health = health;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
